package acezhe.zblog.controller;

import acezhe.zblog.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value="/")
	public String showHomePage(Model model) {
		model.addAttribute("userInfo",new UserInfo());
		return "index";
	}

}
