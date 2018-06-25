package io.github.zhangzheace;

public class AspectJTest{
    public static void main(String[] args){
        Hello hello = new Hello();
        hello.foo();
        hello.addUser("孙悟空","1212");
        World world = new World();
        world.bar();
    }
}
