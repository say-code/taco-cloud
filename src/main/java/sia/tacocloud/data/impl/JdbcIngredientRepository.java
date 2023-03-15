// package sia.tacocloud.data.impl;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.stereotype.Repository;
// import sia.tacocloud.Ingredient;
// import sia.tacocloud.Type;
// import sia.tacocloud.data.IngredientRepository;
//
// import java.sql.ResultSet;
// import java.sql.SQLException;
//
// /**
//  * @author sayCode
//  * @date 2023/2/23 14:01
//  * @project taco-cloud
//  * @Title JdbcIngredientRepository
//  * @description TODO
//  */
// @Repository
// public class JdbcIngredientRepository implements IngredientRepository {
//
//     private final JdbcTemplate jdbc;
//
//     @Autowired
//     public JdbcIngredientRepository(JdbcTemplate jdbc) {
//         this.jdbc = jdbc;
//     }
//     @Override
//     public Iterable<Ingredient> findAll() {
//         return jdbc.query(
//                 "select id, name, type from Ingredient",
//                 this::mapRowToIngredient
//         );
//     }
//
//     @Override
//     public Ingredient findOne(int id) {
//         return jdbc.queryForObject(
//                 "select id, name, type from ingredient where id=?",
//                 this::mapRowToIngredient,
//                 id
//         );
//     }
//
//     @Override
//     public Ingredient save(Ingredient ingredient) {
//         jdbc.update(
//                 "insert into ingredient (id, name, type) values (?, ?, ?)",
//                 ingredient.getId(),
//                 ingredient.getName(),
//                 ingredient.getType().toString()
//         );
//         return ingredient;
//     }
//
//     private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException{
//         return new Ingredient(
//                 rs.getString("id"),
//                 rs.getString("name"),
//                 Type.valueOf(rs.getString("type"))
//         );
//     }
// }
