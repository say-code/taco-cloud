package sia.tacocloud.data;

import sia.tacocloud.Order;

/**
 * @author 汪亦涵
 * @date 2023/2/27 18:19
 * @project taco-cloud
 * @Title OrderRepository
 * @description TODO
 */
public interface OrderRepository {

    Order save(Order order);
}
