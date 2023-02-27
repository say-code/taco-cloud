package sia.tacocloud.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import sia.tacocloud.Ingredient;
import sia.tacocloud.Taco;
import sia.tacocloud.data.TacoRepository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

/**
 * @author sayCode
 * @date 2023/2/27 18:23
 * @project taco-cloud
 * @Title JdbcTacoRepository
 * @description TODO
 */
@Repository
public class JdbcTacoRepository implements TacoRepository {

    private final JdbcTemplate jdbc;

    /**
     * 通过构造器注入JdbcTemplate
     * @param jdbc JdbcTemplate
     */
    @Autowired
    public JdbcTacoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Taco save(Taco design) {
        long tacoId = saveTacoInfo(design);

        for(String ingredient: design.getIngredients()){
            saveIngredientToTaco(ingredient, tacoId);
        }
        System.out.println(design);
        return design;
    }

    private long saveTacoInfo(Taco taco){
        taco.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into taco (name, created_at) values (?, ?)",
                Types.VARCHAR,
                Types.TIMESTAMP);
        //不加这句话会导致keyHolder.getKey()获取不到id
        pscf.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(),
                        new Timestamp(taco.getCreatedAt().getTime())));
        //由于id会在数据库中自动生成，通过正常手段获取id效率Id，故利用keyHolder获取数据库中生成的id
        //这种方法较为繁琐，在JdbcOrderRepository中通过SimpleJdbcInsert来创建
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToTaco(String ingredient, long tacoId){
        jdbc.update(
                "insert into taco_ingredients (taco, ingredient) values (?, ?)",
               tacoId,
               ingredient);
    }
}
