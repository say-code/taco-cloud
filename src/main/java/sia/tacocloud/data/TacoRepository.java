package sia.tacocloud.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.Order;
import sia.tacocloud.Taco;

/**
 * @author 汪亦涵
 * @date 2023/2/27 18:18
 * @project taco-cloud
 * @Title TacoRepository
 * @description TODO
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {

    // Taco save(Taco design);
}
