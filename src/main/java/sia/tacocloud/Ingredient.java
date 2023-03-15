package sia.tacocloud;

import lombok.*;

import javax.persistence.*;


/**
 * @author sayCode
 * @date 2023/2/21 18:42
 * @project taco-cloud
 * @Title Ingredient
 * @description taco 配料
 */
@Data
//@Data注解会为我们添加一个有参构造器，但是添加NoArgsConstructor后，
//  这个构造器会被删除掉，我们显示的添加@RequiredArgsConstructor以确保有参构造器的存在
// @RequiredArgsConstructor
//JPA需要实体有一个无参构造器，因为属性中有final，所以将force设置为true，
//  这样Lombok生成的构造器就会将他们设置为null
@AllArgsConstructor
@NoArgsConstructor(force = true)
//为将Ingredient声明为JPA实体，必须添加这个注解
@Entity
public class Ingredient {
    //JPA需要该注解以便于将其指定为数据库中唯一标识该实体的属性
    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

}

