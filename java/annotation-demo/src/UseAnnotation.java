import annotation.Author;
import annotation.CompositeAnnotation;
import annotation.Description;

@Author
@Description("这个 类 使用了Description注解")
public class UseAnnotation {

    @CompositeAnnotation
    private String text = UseAnnotation.class.getSimpleName();

    @Author(name = "权得月", email = "quandeyue@qq.com", group = "girl", phone = "00000000")
    @Description("这个方法会把成员变量打印出来")
    @Description("这个方法有两个 @Description 注解")
    public void printText() {
        System.out.println("类名称是:" + text);
    }
}
