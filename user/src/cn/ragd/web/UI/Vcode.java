package cn.ragd.web.UI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ragd.utils.VerifyCode;

@Controller
public class Vcode {
	
	@RequestMapping("/vcode.html")
	public void vcode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		VerifyCode verifyCode = new VerifyCode();
        VerifyCode.output(verifyCode.getImage(),response.getOutputStream());//实例代码开始运行，在此之前验证码尚未生成，值为null
        System.out.println("vcode_img "+verifyCode.getText()+"");
        request.getSession().setAttribute("vcode",verifyCode.getText());
	}

}
