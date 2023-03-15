package sia.tacocloud.web.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.Taco;
import sia.tacocloud.data.TacoRepository;

import java.util.Optional;

/**
 * @author sayCode
 * @date 2023/3/15 19:28
 * @project taco-cloud
 * @Title DesignTacoApiController
 * @description TODO
 */

@RestController
//produces 用于指定输出
@RequestMapping(path = "/api/design",
                produces = "application/json")
//允许跨域请求
@CrossOrigin(origins = "*")
public class DesignTacoApiController {

    private TacoRepository tacoRepository;

    public DesignTacoApiController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    /**
     * 截取冰返回最近设计的Taco
     * @return Taco taco
     */
    @GetMapping("recent")
    public Iterable<Taco> recentTacos(){
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending()
        );

        return tacoRepository.findAll(page);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id){
        Optional<Taco> optionalTaco = tacoRepository.findById(id);
        return optionalTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }


    /**
     * consumes用于指定输入
     * <p> HttpStatus.CREATED 201 ：由于200的描述性不足，在POST请求的情况下，201的状态更具有描述性</p>
     * <p>它会告诉客户端，请求不仅成功了，还创建了资源。</p>
     * @param taco taco 表名请求应该被转换成一个Taco对象并绑定到该参数上
     * @return taco
     */
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco){
        return tacoRepository.save(taco);
    }
}
