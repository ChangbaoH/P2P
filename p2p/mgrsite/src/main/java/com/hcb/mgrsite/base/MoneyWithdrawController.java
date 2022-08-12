package com.hcb.mgrsite.base;

import com.hcb.p2p.base.util.JSONResult;
import com.hcb.p2p.business.query.MoneyWithdrawQueryObject;
import com.hcb.p2p.business.service.IMoneyWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 提现申请审核
 * 
 * @author Administrator
 * 
 */
@Controller
public class MoneyWithdrawController {

	@Autowired
	private IMoneyWithdrawService moneyWithdrawService;

	@RequestMapping("moneyWithdraw")
	public String moneyWithdrawList(
			@ModelAttribute("qo") MoneyWithdrawQueryObject qo, Model model) {
		model.addAttribute("pageResult", this.moneyWithdrawService.query(qo));
		return "moneywithdraw/list";
	}

	@RequestMapping("moneyWithdraw_audit")
	@ResponseBody
	public JSONResult audit(Long id, String remark, int state) {
		this.moneyWithdrawService.audit(id, remark, state);
		return new JSONResult();
	}

}
