package the.oronco.customjdbcreturntypes.stuff;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.springframework.data.util.Streamable;

/**
 * @author the_oronco@posteo.net
 * @since 10/03/2024
 */
public sealed interface Wrapper<T> extends Streamable<T> {
    record A<T>(T value) implements Wrapper<T> {

    }

    record B<T>() implements Wrapper<T> {

    }

    @Override
    default Iterator<T> iterator() {
        return switch (this) {
            case A<T>(T value) -> List.of(value)
                                              .iterator();
            case Wrapper.B<T> v -> Collections.emptyIterator();
        };
    }
    static <T> Wrapper<T> of(Streamable<T> streamable) {
        var l = streamable.stream()
                          .toList();
        if (l.size() == 1) {
            return new A<>(l.getFirst());

        } else {
            return new B<>();
        }
    }

//    static <T> Wrapper<T> of(T val){
//        return val == null ? new B<>() : new A<>(val);
//    }
}

