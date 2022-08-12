package com.hcb.mgrsite.base;

import com.hcb.p2p.base.util.JSONResult;
import com.hcb.p2p.business.query.RechargeOfflineQueryObject;
import com.hcb.p2p.business.service.IPlatformBankInfoService;
import com.hcb.p2p.business.service.IRechargeOfflineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 线下充值审核
 * 
 * @author Administrator
 * 
 */
@Controller
public class RechargeOfflineController {
	@Autowired
	private IRechargeOfflineService rechargeOfflineService;

	@Autowired
	private IPlatformBankInfoService platformBankInfoService;

	@RequestMapping("rechargeOffline")
	public String rechargeOffline(
			@ModelAttribute("qo") RechargeOfflineQueryObject qo, Model model) {
		model.addAttribute("banks", this.platformBankInfoService.listAll());
		model.addAttribute("pageResult", this.rechargeOfflineService.query(qo));
		return "rechargeoffline/list";
	}

	/**
	 * 线下充值审核
	 */
	@RequestMapping("rechargeOffline_audit")
	@ResponseBody
	public JSONResult audit(Long id, String remark, int state) {
		this.rechargeOfflineService.audit(id, remark, state);
		return new JSONResult();
	}

}
