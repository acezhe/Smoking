package acezhe;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author zhangzhe
 */
public class SearchService {

    public static void doSearch() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请大侠选择查询内容\n" +
                    "1:查询大侠角色\n" +
                    "2:查询大侠权限\n" +
                    "3:返回");
            String ret = scan.next();
            switch (ret) {
                case "1": {
                    queryRoles();
                    break;
                }
                case "2": {
                    queryPermission();
                    break;
                }
                case "3":{
                    return;
                }
                default: {
                    System.out.println("选择错误，请重试！");
                    continue;
                }
            }
        }
    }

    private static void queryPermission() {
        Session session = SecurityUtils.getSubject().getSession();
        String username = (String) session.getAttribute(AuthUtils.CURRENT_USER_ID);
        try (Connection conn = DatabaseUtils.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select distinct p.permission_name from role r left join user_role ur on r.id=ur.role_id left join user u on u.id=ur.user_id left join role_permission rp on r.id=rp.role_id left join permission p on p.id=rp.permission_id where u.username like ?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            System.out.println("您的权限为:");
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void queryRoles() {
        Session session = SecurityUtils.getSubject().getSession();
        String username = (String) session.getAttribute(AuthUtils.CURRENT_USER_ID);
        try (Connection conn = DatabaseUtils.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select distinct r.role_name from role r left join user_role ur on r.id=ur.role_id left join user u on u.id=ur.user_id left join role_permission rp on r.id=rp.role_id left join permission p on p.id=rp.permission_id where u.username like ?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            System.out.println("您的角色为:");
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
