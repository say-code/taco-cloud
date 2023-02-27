package sia.tacocloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;


/**
 * @author sayCode
 * @date 2023/2/21 18:42
 * @project taco-cloud
 * @Title Ingredient
 * @description taco 配料
 */
@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

}

