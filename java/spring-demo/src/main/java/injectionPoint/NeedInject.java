package injectionPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeedInject {
    @Autowired
    private TestBean testBean;

    public void dod(){
        System.out.println(testBean.getStr());
    }
}
