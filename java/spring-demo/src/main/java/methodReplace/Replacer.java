package methodReplace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Replacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Object Name:"+o.getClass().getSimpleName());
        System.out.println("Method Name:"+method.getName());
        System.out.println("Arguments:"+ Arrays.toString(objects));

        return method.getName()+" be replaced. args:"+Arrays.toString(objects);

    }
}
