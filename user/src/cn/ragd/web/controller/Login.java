package cn.ragd.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.ragd.domain.User;
import cn.ragd.service.BusinessService;

@Controller
public class Login {

	@Autowired
	private BusinessService service;	

	@RequestMapping(value="/login.html",method={RequestMethod.POST})
	public String loginUser(HttpServletRequest request) throws Exception {
		
		//��ȡ���ύ���û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		User user = service.login(username, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			//���û���½�ɹ�����ת��ҳ
			//response.sendRedirect(request.getContextPath() + "/index.jsp");
			return "redirect:index.jsp";
		}
						
		request.setAttribute("message", "�û�����������󣡣�");
		//request.getRequestDispatcher("/message.jsp").forward(request, response);
		return "forward:message.jsp";
	}
	
}
