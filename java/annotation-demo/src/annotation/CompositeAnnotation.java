package annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Description("这是一个组合注解")
@Author
public @interface CompositeAnnotation {

}
