package acezhe;

import java.util.Objects;
import java.util.Scanner;

/**
 * 程序启动
 * @author zhangzhe
 */
public class Startup {
    public static void main(String[] args) {
        ShiroInit.init();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎使用 basic shiro 测试系统！！");
            System.out.println("请问您是否登录(y/n)?");
            String ans = scan.next();
            if (Objects.equals("y", ans)) {
                if (AuthUtils.checkLogin()) {
                    ModelService.doServ();
                    continue;
                } else {
                    System.exit(0);
                }
            } else {
                System.exit(0);
            }
        }
    }
}
