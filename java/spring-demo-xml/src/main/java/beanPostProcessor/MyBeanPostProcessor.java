package beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class MyBeanPostProcessor implements BeanPostProcessor, Ordered, BeanNameAware {
    private int order = -1;
    private String processorName;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(processorName + " before bean " + beanName + " initialization.");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(processorName + " after bean " + beanName + " initialization.");
        return bean;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setBeanName(String name) {
        processorName = name;
    }
}
