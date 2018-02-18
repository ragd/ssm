package cn.ragd.web.UI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//为用户提供注册登陆界面（在index.jsp中调用，跳转到register.jsp或login.jsp）
@Controller
@RequestMapping("/UI")
public class UserUI {

	@RequestMapping("/register.html")
	public ModelAndView registerUI() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/register.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/login.html")
	public ModelAndView loginUI() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/login.jsp");
		return modelAndView;
	}
	
}
