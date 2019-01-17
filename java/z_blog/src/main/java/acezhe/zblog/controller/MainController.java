package acezhe.zblog.controller;

import acezhe.zblog.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 主要的控制层
 */
@Controller
public class MainController {

	@GetMapping(value={"/","/index","/login"})
	public String showHomePage(Model model) {
		return "index";
	}

}
