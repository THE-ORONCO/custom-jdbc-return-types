package the.oronco.customjdbcreturntypes.stuff;


import java.util.List;
import org.springframework.data.repository.Repository;
import org.springframework.data.util.Streamable;

/**
 * @author the_oronco@posteo.net
 * @since 10/03/2024
 */
public interface Repo extends Repository<Dummy, Long> {
    Dummer getById(Long id);
//    Dummer getAllById(Long id);
    Wrapper<Dummy> getAllById(Long id);
    List<Dummy> findAllByName(String name);
    Iterable<Dummy> findAll();
    Dummy save(Dummy dummy);
}
