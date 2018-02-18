package cn.ragd.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Logout {

	//处理注销请求
	//对该方法进行url映射
	@RequestMapping("/logout.html")
	public ModelAndView logoutUser(HttpServletRequest request) throws Exception {
		
		//创建ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		//获取内存中的session
		HttpSession session = request.getSession(false);
		if(session!=null){
			//移除登陆标记
			session.removeAttribute("user");
			
			//清除session
			//session.invalidate();
		}
						
		//注销成功，跳转到全局消息显示页面，显示注销成功消息，并控制消息显示页面超过6秒后跳转到首页
		modelAndView.addObject("message", "注销成功，浏览器将在6秒后跳转！！<meta http-equiv='refresh' content='6;url="+request.getContextPath()+"/index.jsp'>");
		modelAndView.setViewName("/message.jsp");
				
		return modelAndView;
	}
}
