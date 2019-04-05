package injectionPoint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("injectionPoint");

        NeedInject needInject = (NeedInject) configApplicationContext.getBean("needInject");
        needInject.dod();
    }
}
