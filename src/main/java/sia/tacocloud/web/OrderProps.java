package sia.tacocloud.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author sayCode
 * @date 2023/3/13 16:46
 * @project taco-cloud
 * @Title OrderProps
 * @description 定义配置属性持有者 将配置文件中的参数抽取到该类中
 */
@Component
@ConfigurationProperties(prefix = "taco.orders")
@Data
public class OrderProps {

    @Min(value = 5, message = "must be between 5 and 25")
    @Max(value = 25, message = "must be between 5 and 25")
    private int pageSize = 20;
}
