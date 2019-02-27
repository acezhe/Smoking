package injectionPoint;

public class TestBean {
    String str;
    public TestBean(String s) {
        str = s;
    }

    public String getStr() {
        return str;
    }
}
