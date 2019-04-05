package injectionPoint;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * {@link InjectionPoint} 可以让产生要被注入的 bean 的方法取得注入该被产生 bean 的对象信息。
 * 如本例子，{@link #prototypeInstance(InjectionPoint)} 方法产生 {@link TestBean} bean，注入到
 * {@link NeedInject} bean 中，{@link #prototypeInstance(InjectionPoint)} 方法通过 {@link InjectionPoint}
 * 取得了 {@link NeedInject} 的信息。
 */
@Component
public class FactoryMethodComponent {
    @Bean
    @Scope("prototype")
    public TestBean prototypeInstance(InjectionPoint injectionPoint) {

        return new TestBean("prototypeInstance for " + injectionPoint.getMember()+ " - "+ injectionPoint.getAnnotations()[0]);
    }


}
