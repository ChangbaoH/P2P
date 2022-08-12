package com.hcb.mgrsite.base;

import com.hcb.p2p.base.query.UserFileQueryObject;
import com.hcb.p2p.base.service.IUserFileService;
import com.hcb.p2p.base.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 风控资料审核
 * 
 * @author Administrator
 * 
 */
@Controller
public class UserFileController {
	
	@Autowired
	private IUserFileService userFileService;
	
	@RequestMapping("userFileAuth")
	public String userFileAuthList(@ModelAttribute("qo") UserFileQueryObject qo, Model model){
		model.addAttribute("pageResult",this.userFileService.query(qo));
		return "userFileAuth/list";
	}
	
	/**
	 * 审核
	 */
	@RequestMapping("userFile_audit")
	@ResponseBody
	public JSONResult audit(Long id, int score, String remark, int state){
		this.userFileService.audit(id,score,remark,state);
		return new JSONResult();
	}

}
