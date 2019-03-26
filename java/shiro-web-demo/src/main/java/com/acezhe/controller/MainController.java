package com.acezhe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhangzhe
 */
@Controller
public class MainController {
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
    public String showRole(){
        return "showRole";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/search/permission")
    public String showPermission(){
        return "showPermission";
    }
    @RequestMapping(method =RequestMethod.GET,path = "/loginPage")
    public String goLogin(){
        return "login";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/unauthorized")
    public String goUnauthorized(){
        return "unauthorized";
    }

}
