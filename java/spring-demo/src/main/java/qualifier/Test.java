package qualifier;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("qualifier.xml");
        Factory factory = (Factory) context.getBean("factory");
        factory.who();
        CustomAnnoFactory customAnnoFactory = (CustomAnnoFactory) context.getBean("customAnnoFactory");
        customAnnoFactory.who();
    }
}
