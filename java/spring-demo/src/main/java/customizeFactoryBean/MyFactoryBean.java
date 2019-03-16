package customizeFactoryBean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<People> {

    private boolean isSingleton = true;
    private People singletonInstance;
    @Override
    public People getObject() throws Exception {
        if (isSingleton) {
            if (singletonInstance == null) {
                singletonInstance = new People("zhangzhe");
            }
            return singletonInstance;
        }
        return new People();
    }

    @Override
    public Class<?> getObjectType() {
        return People.class;
    }

    public void setSingleton(boolean singleton) {
        isSingleton = singleton;
    }

    @Override
    public boolean isSingleton() {
        return isSingleton;
    }
}
