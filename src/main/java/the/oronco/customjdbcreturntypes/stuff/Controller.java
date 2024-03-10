package the.oronco.customjdbcreturntypes.stuff;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author the_oronco@posteo.net
 * @since 10/03/2024
 */
@RestController
@AllArgsConstructor
public class Controller {
    private final Repo repo;

    @GetMapping("/dummies")
    public Iterable<Dummy> all() {
        return repo.findAll();
    }

    @GetMapping("/dummies/with-id/{id}")
    public String all(@PathVariable Long id) {
        System.out.println(repo.getAllById(id)
                               .stream()
                               .findFirst());
        System.out.println((repo.getAllById(id)));
        return "uff";
    }

    @GetMapping("/dummies/named/{name}")
    public Integer named(@PathVariable String name) {
        return repo.findAllByName(name)
                   .size();
    }

    @PostMapping("/dummies")
    public Dummy dummy(@RequestBody Dummy dummy) {
        return repo.save(dummy);
    }
}
