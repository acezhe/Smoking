import annotation.Author;
import annotation.Description;

@Author
@Description("这个 类 使用了Description注解")
public class UseAnnotation {
    @Author
    @Description("这个 成员变量 使用了Description注解")
    private String text = UseAnnotation.class.getSimpleName();

    @Author(name = "权得月", email = "quandeyue@qq.com", group = "girl", phone = "00000000")
    @Description("这个方法会把成员变量打印出来")
    public void printText() {
        System.out.println("类名称是:" + text);
    }
}
