package com.acezhe.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangzhe
 */
@Controller
public class MainController {
    @Autowired
    private DataSource dataSource;
    @RequestMapping(method = RequestMethod.GET,path = {"/index","/"})
    public String goIndex(){

        return "index";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/service")
    public String goService(){
        return "service";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/service/playCard")
    public String goPlayCard(){
        return "playCard";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/service/watchMovie")
    public String goWatchMovie(){
        return "watchMovie";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/search")
    public String goSearch(){
        return "search";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/search/role")
    public ModelAndView showRole(){

        Map m = new HashMap();
        try ( Connection connection = dataSource.getConnection()){
            String principal = (String) SecurityUtils.getSubject().getPrincipal();
            PreparedStatement ps = connection.prepareStatement("select distinct r.role_name from role r left join user_role ur on r.id=ur.role_id left join user u on u.id=ur.user_id left join role_permission rp on r.id=rp.role_id left join permission p on p.id=rp.permission_id where u.username like ?");
            ps.setString(1, principal);
            ResultSet rs = ps.executeQuery();

            List l = new ArrayList();
            while (rs.next()){
                String role = rs.getString("role_name");
                l.add(role);

            }
            m.put("roles",l);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("showRole","roles",m);
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.GET,path = "/search/permission")
    public String showPermission(Model model){
        System.out.println("aaaa");
        try ( Connection connection = dataSource.getConnection()){
            String principal = (String) SecurityUtils.getSubject().getPrincipal();
            PreparedStatement ps = connection.prepareStatement("select distinct p.permission_name from role r left join user_role ur on r.id=ur.role_id left join user u on u.id=ur.user_id left join role_permission rp on r.id=rp.role_id left join permission p on p.id=rp.permission_id where u.username like ?");
            ps.setString(1, principal);
            ResultSet rs = ps.executeQuery();

            List l = new ArrayList();
            while (rs.next()){
                String role = rs.getString("permission_name");
                l.add(role);

            }
            model.addAttribute("perms",l);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "showPermission";
    }
    @RequestMapping(method ={RequestMethod.POST,RequestMethod.GET},path = "/loginPage")
    public String goLogin(){
        return "loginPage";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/unauthorized")
    public String goUnauthorized(){
        return "unauthorized";
    }


}
