package annotation;

import java.lang.annotation.*;

/**
 * 定义作者信息,name,email,group,phone
 * @author zhangzhe
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
@Documented
public @interface Author {
    String name() default "zhangzhe";
    String email() default "zhangzhe.ace@foxmail.com";
    String group() default "Avalon";
    String phone() default "17792723743";


}
