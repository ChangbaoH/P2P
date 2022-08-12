package com.hcb.p2p.base.controller;

import com.hcb.p2p.base.query.IplogQueryObject;
import com.hcb.p2p.base.service.IIplogService;
import com.hcb.p2p.base.util.RequireLogin;
import com.hcb.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 登陆日志
 * 
 * @author Administrator
 * 
 */
@Controller
public class IplogController {

	@Autowired
	private IIplogService iplogService;

	/**
	 * 个人用户登陆记录列表
	 * @param qo
	 * @param model ModelAttribute把IplogQueryObject qo放入model里，名字为qo addAttribute("qo",qo)
	 * @return
	 */
	@RequireLogin
	@RequestMapping("ipLog")
	public String iplogList(@ModelAttribute("qo") IplogQueryObject qo, Model model) {
		qo.setUsername(UserContext.getCurrent().getUsername());
		model.addAttribute("pageResult",this.iplogService.query(qo));
		return "iplog_list";
	}

}
