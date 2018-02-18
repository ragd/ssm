package cn.ragd.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.ragd.domain.User;
import cn.ragd.exception.UserExistException;
import cn.ragd.service.BusinessService;
import cn.ragd.utils.WebUtils;
import cn.ragd.web.formbean.RegisterForm;

@Controller
public class Register {
	
	@Autowired
	private BusinessService service;

	@RequestMapping(value="/register.html",method={RequestMethod.POST})
	public ModelAndView registerUser(HttpServletRequest request) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		request.setCharacterEncoding("UTF-8");
		
		//1.���ύ�����ֶν��кϷ���У��(�ѱ����ݷ�װ��formbean)
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b1 = form.validate();
		
		//��ȡsession�е���֤�룬��У���Ƿ���ȷ
		String sessionVcode = (String)request.getSession().getAttribute("vcode");
		boolean b2 = form.testVcode(sessionVcode);
		
		//2.���У��ʧ�ܣ����ص���ҳ�棬����У��ʧ����Ϣ
		if(!b1 || !b2){
			//��������Ϣ�浽form���У�����ע��ҳ����
			modelAndView.addObject("form", form);
			modelAndView.setViewName("/WEB-INF/jsp/register.jsp");
			return modelAndView;
		}
		
		//3.���У��ɹ��������service����ע������
		User user = new User();
		WebUtils.copyBean(form, user);
		
		try {
			service.register(user);
			//6.���service����ɹ�������ת��ȫ����Ϣ��ʾҳ�棬��ʾ�ɹ�ע����Ϣ��������6�����ת����ҳ
			modelAndView.addObject("message", "��ϲ����ע��ɹ������������6�����ת����<meta http-equiv='refresh' content='6;url="+request.getContextPath()+"/index.jsp'>");
			modelAndView.setViewName("/message.jsp");
			return modelAndView;
		} catch (UserExistException e) {
			//4.���service�����ɹ�����������Ϊע���û��Ѵ��ڣ������ص�ע��ҳ�棬��ʾע���û��Ѵ��ڵ���Ϣ
			form.getErrors().put("username", "ע����û��Ѵ��ڣ�");
			modelAndView.addObject("form", form);
			modelAndView.setViewName("/WEB-INF/jsp/register.jsp");
			return modelAndView;
		} catch (Exception e) {
			//5.���service�����ɹ�����������Ϊ�������⣬����ת����վ��ȫ����Ϣ��ʾҳ��
			e.printStackTrace();
			modelAndView.addObject("message", "����������δ֪����");
			modelAndView.setViewName("/message.jsp");
			return modelAndView;
		}
	}
	
}
