package acezhe.zblog.controller;

import acezhe.zblog.entity.UserInfo;
import acezhe.zblog.service.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserInfoDao userInfoDao;

    @PostMapping(value = "/register")
    public ModelAndView userRegister(Model model, UserInfo userInfo){

        userInfoDao.save(userInfo);
        System.out.println(userInfo.toString());
//        ModelAndView("")

        return new ModelAndView("redirect:/");

    }
}
