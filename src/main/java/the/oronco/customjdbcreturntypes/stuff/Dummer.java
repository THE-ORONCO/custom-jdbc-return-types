package the.oronco.customjdbcreturntypes.stuff;

import java.util.Iterator;
import org.springframework.data.util.Streamable;

/**
 * @author the_oronco@posteo.net
 * @since 10/03/2024
 */
public class Dummer implements Streamable<Dummy> {
    private final Streamable<Dummy> streamable;

    public Dummer(Streamable<Dummy> streamable) {this.streamable = streamable;}

    @Override
    public Iterator<Dummy> iterator() {
        return streamable.iterator();
    }
}
