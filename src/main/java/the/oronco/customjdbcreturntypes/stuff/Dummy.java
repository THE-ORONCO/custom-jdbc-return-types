package the.oronco.customjdbcreturntypes.stuff;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author the_oronco@posteo.net
 * @since 10/03/2024
 */
@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Dummy {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
