package acezhe;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ServiceService {
    private static Map<String,String> services = new HashMap<>();
    static {
        init();
    }

    private static void init() {
        services.put("1","打牌");
        services.put("2","看片");
    }

    public static void doServ(){
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("本应用提供以下服务："+ services.toString());
            System.out.print("请选择服务类型(输入 full 返回)：");
            String serType = scan.next();
            if (Objects.equals("full",serType)){
                break;
            }
            String serInfo = services.get(serType);
            if (Objects.isNull(serInfo)){
                System.out.println("大侠要的服务我们木有，请重新选择！！");
                continue;
            }
            try {
                if (Objects.equals("1", serType)) {
                    SecurityUtils.getSubject().checkRole("player");
                } else {
                    SecurityUtils.getSubject().checkPermission("service:watchmovie");
                }
            }catch (AuthorizationException ae){
                System.out.println("大侠不可以！您没有权限。。");
                continue;
            }
            System.out.println("大侠体验了"+serInfo+"，生命值增加了"+Math.random()*1000);
        }
    }
}
