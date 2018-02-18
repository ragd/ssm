package cn.ragd.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Logout {

	//����ע������
	//�Ը÷�������urlӳ��
	@RequestMapping("/logout.html")
	public ModelAndView logoutUser(HttpServletRequest request) throws Exception {
		
		//����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		//��ȡ�ڴ��е�session
		HttpSession session = request.getSession(false);
		if(session!=null){
			//�Ƴ���½���
			session.removeAttribute("user");
			
			//���session
			//session.invalidate();
		}
						
		//ע���ɹ�����ת��ȫ����Ϣ��ʾҳ�棬��ʾע���ɹ���Ϣ����������Ϣ��ʾҳ�泬��6�����ת����ҳ
		modelAndView.addObject("message", "ע���ɹ������������6�����ת����<meta http-equiv='refresh' content='6;url="+request.getContextPath()+"/index.jsp'>");
		modelAndView.setViewName("/message.jsp");
				
		return modelAndView;
	}
}
