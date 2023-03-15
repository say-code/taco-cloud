package sia.tacocloud.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.Order;
import sia.tacocloud.Users;
import sia.tacocloud.data.OrderRepository;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author sayCode
 * @date 2023/2/22 15:08
 * @project taco-cloud
 * @Title OrderController
 * @description TODO
 */

@Slf4j
@Controller
@RequestMapping("/orders")
//让order作为Session参数，使得一个order可以订多个order
@SessionAttributes("order")
//自定义配置属性，便于后期修改
// @ConfigurationProperties(prefix = "taco.orders")
public class OrderController {

    private final OrderRepository orderRepo;

    private final OrderProps orderProps;

    @Autowired
    public OrderController(OrderRepository orderRepo, OrderProps orderProps) {
        this.orderRepo = orderRepo;
        this.orderProps = orderProps;
    }

    @GetMapping("/current")
    public String orderForm(Model model){
        // model.addAttribute("order",new Order());
        return "orderForm";
    }

    /**
     * 基于thymeleaf的分页查询
     * @param users 用户信息，由SpringSecurity负责传递
     * @param model thymeleaf
     * @return 页面
     */
    @GetMapping
    public String orderForUser(@AuthenticationPrincipal Users users, Model model){

        Pageable pageable = PageRequest.of(0, orderProps.getPageSize());
        model.addAttribute("orders",
                orderRepo.findByUserOrderByPlacedAtDesc(users, pageable));
        return "orderList";
    }

    @PostMapping
    public String processOrder(@Valid Order order,
                               Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal Users user){
        if (errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted:" + order);
        order.setUser(user);
        //以下可以在程序的任何地方使用
        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Users users = (Users) auth.getPrincipal();
        // --------------
        log.info("notice here! "+order.getTacos().toString());
        order.setPlacedAt(new Date());
        orderRepo.save(order);
        //完成订单后清空参数，不然下一次的订单将会从旧订单中保存的taco开始
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
