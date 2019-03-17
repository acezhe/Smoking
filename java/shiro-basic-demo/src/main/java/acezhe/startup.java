package acezhe;

import org.apache.shiro.SecurityUtils;

import java.util.Scanner;

public class startup {
    public static void main(String[] args) {
        ShiroInit.init();
        while (true) {
            System.out.println("欢迎使用 basic shiro 测试系统！！");
            Scanner scan = new Scanner(System.in);
            if (AuthUtils.checkLogin() || AuthUtils.login()) {
                System.out.println();
                System.out.println(SecurityUtils.getSubject().getSession().getAttribute("currentUserId") + "登录成功");
                ModelService.doServ();
                continue;
            } else {
                System.exit(0);
            }
        }
    }
}
