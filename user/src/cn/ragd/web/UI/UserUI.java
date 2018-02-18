package cn.ragd.web.UI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Ϊ�û��ṩע���½���棨��index.jsp�е��ã���ת��register.jsp��login.jsp��
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
