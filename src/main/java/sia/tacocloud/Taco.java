package sia.tacocloud;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author sayCode
 * @date 2023/2/22 14:28
 * @project taco-cloud
 * @Title Taco
 * @description TODO
 */
@Entity
@NoArgsConstructor(force = true)
@Data
public class Taco {
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long.")
    private String name;
    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "You must choose at leas 1 ingredient.")
    private List<Ingredient> ingredients;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;
}
