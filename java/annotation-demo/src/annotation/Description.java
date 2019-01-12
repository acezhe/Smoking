package annotation;

import java.lang.annotation.*;

/**
 * 用来做详细描述的注解
 * @author zhangzhe
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Repeatable(value = Descriptions.class)
public @interface Description {
    String value();
}
