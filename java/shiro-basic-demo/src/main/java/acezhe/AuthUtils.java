package acezhe;

import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import java.util.Objects;
import java.util.Scanner;

@Log4j2
public class AuthUtils {
    public static boolean login() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("请输入用户名：");
            String username = scan.next();
            if (Objects.equals("exit", username)) {
                return false;
            }
            System.out.print("请输入密码：");
            String password = scan.next();

            AuthenticationToken token = new UsernamePasswordToken(username, password);
            try {
                Subject subject = SecurityUtils.getSubject();
                subject.login(token);
                if (subject.isAuthenticated()) {
                    SecurityUtils.getSubject().getSession().setAttribute("currentUserId",username);
                    return true;
                }
            } catch (AuthenticationException ae) {
                log.warn("非法登录，用户名：{}", username);
                System.out.println("用户名或密码错误，请重新登录！！(输入 exit 退出程序)");
                continue;
            }
        }
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static boolean checkLogin(){
        if (SecurityUtils.getSubject().isAuthenticated()){
            return true;
        }else {
            return false;
        }
    }
}
