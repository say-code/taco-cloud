package sia.tacocloud.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.Order;
import sia.tacocloud.Users;

import java.util.List;

/**
 * @author 汪亦涵
 * @date 2023/2/27 18:19
 * @project taco-cloud
 * @Title OrderRepository
 * @description TODO
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    // Order save(Order order);

    List<Order> findByUserOrderByPlacedAtDesc(Users users, Pageable pageable);
}
