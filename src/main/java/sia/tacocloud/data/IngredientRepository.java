package sia.tacocloud.data;

import sia.tacocloud.Ingredient;

/**
 * @author sayCode
 * @date 2023/2/23 14:05
 * @project taco-cloud
 * @Title IngredientRepository
 * @description TODO
 */
public interface IngredientRepository {

    /**
     * 查询所有的配料信息，将他们放到一个Ingredient对象的集合中
     * @return 配料集合
     */
    Iterable<Ingredient> findAll();

    /**
     * 根据id，查询单个Ingredient
     * @param id 编号
     * @return Ingredient
     */
    Ingredient findOne(int id);

    /**
     * 保存Ingredient对象
     * @param ingredient 配料信息
     * @return 保存
     */
    Ingredient save(Ingredient ingredient);
}
