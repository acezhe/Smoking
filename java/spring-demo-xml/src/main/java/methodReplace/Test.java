package methodReplace;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class Test {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("methodReplace.xml");
        context.refresh();

        BeReplace beReplace = context.getBean(BeReplace.class);
        String i = beReplace.willBeReplaced("Who",8);
        System.out.println("Method return:"+i);
    }
}
