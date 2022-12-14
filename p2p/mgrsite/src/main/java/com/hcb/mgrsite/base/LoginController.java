package com.hcb.mgrsite.base;

import com.hcb.p2p.base.domain.Logininfo;
import com.hcb.p2p.base.service.ILogininfoService;
import com.hcb.p2p.base.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;



/**
 * 后台登陆
 * 
 * @author Administrator
 * 
 */
@Controller
public class LoginController {

	@Autowired
	private ILogininfoService logininfoService;

	/**
	 * 后台登陆
	 * 
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public JSONResult login(String username, String password,
							HttpServletRequest request) {
		JSONResult json = new JSONResult();
		Logininfo current = this.logininfoService.login(username, password,
				request.getRemoteAddr(), Logininfo.USER_MANAGER);
		if (current == null) {
			json.setSuccess(false);
			json.setMsg("用户名或者密码错误!");
		}
		return json;
	}

	/**
	 * 后台首页
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "main";
	}
}
