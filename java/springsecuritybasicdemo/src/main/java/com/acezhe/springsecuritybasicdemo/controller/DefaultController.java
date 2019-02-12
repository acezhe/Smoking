package com.acezhe.springsecuritybasicdemo.controller;

import com.acezhe.springsecuritybasicdemo.entity.UserInfo;
import com.acezhe.springsecuritybasicdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Default controller handle any request.
 */
@Controller
@Slf4j
public class DefaultController {

    private final UserService userService;

    @Autowired
    public DefaultController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String toMainPage() {
        log.info("forward to index.");
        return "index";
    }

    @RequestMapping(path = "/toLogin",method = {RequestMethod.GET,RequestMethod.POST})
    public String toLoginPage(){
        log.info("forward to login.");
        return "login";
    }

    @RequestMapping(path = "/toRegister",method = RequestMethod.GET,produces = "text/html")
    public ModelAndView toRegisterPage(){
        log.info("forward to register.");
        ModelAndView view = new ModelAndView();
        view.setViewName("register");
        return view;
    }

    @RequestMapping(path = "/user/userPage",method = RequestMethod.GET,produces = "text/html")
    public ModelAndView toUserPage(){
        log.info("forward to user.");
        return new ModelAndView("user/userPage");
    }

    @RequestMapping(path = "/admin/adminPage",method = RequestMethod.GET,produces = "text/html")
    public ModelAndView toAdminPage(){
        log.info("forward to admin.");
        return new ModelAndView("admin/adminPage");
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public ModelAndView register(String username,String password,String roles){
        ModelAndView view = new ModelAndView("/index");

        if(null!=userService.register(new UserInfo(username,password,roles))){
            view.addObject("regMsg","success");
        }else {
            view.addObject("regMsg","failed");
            view.setViewName("/register");
        }
        return view;
    }

}
