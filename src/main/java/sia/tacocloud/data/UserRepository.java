package sia.tacocloud.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.Users;

/**
 * @author 汪亦涵
 * @date 2023/3/2 15:46
 * @project taco-cloud
 * @Title UserRepository
 * @description TODO
 */
public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByUsername(String username);


}
