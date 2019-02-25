package beanPostProcessor;

import org.springframework.beans.factory.BeanNameAware;

public class SimpleBean implements BeanNameAware {
    private String beanName;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init(){
        System.out.println(beanName + " init.");
    }

    public void dispose(){
        System.out.println(beanName + " dispose.");
    }
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
