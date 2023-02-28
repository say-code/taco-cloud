package sia.tacocloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.Order;
import sia.tacocloud.data.OrderRepository;

import javax.validation.Valid;

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
public class OrderController {

    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("order",new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted:" + order);
        orderRepo.save(order);
        //完成订单后清空参数，不然下一次的订单将会从旧订单中保存的taco开始
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
