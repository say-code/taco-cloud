package sia.tacocloud.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sayCode
 * @date 2023/2/23 11:32
 * @project taco-cloud
 * @Title WebConfig
 * @description WebMvcConfigure 定义了多个方法来配置springMVC，
 * 尽管他只是一个接口，但是他提供了所有方法的默认实现，只需要覆盖所需的方法即可。
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 该方法会接收一个ViewControllerRegistry对象，可以用它来注册一个或多个视图控制器
     * @param registry 注册视图控制器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}
