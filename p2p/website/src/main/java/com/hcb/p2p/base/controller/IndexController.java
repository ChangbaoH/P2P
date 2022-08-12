package com.hcb.p2p.base.controller;

import com.hcb.p2p.base.util.BidConst;
import com.hcb.p2p.business.query.BidRequestQueryObject;
import com.hcb.p2p.business.service.IBidRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 网站首页
 * 
 * @author Administrator
 * 
 */
@Controller
public class IndexController {

	@Autowired
	private IBidRequestService bidRequestService;

	@RequestMapping("index")
	public String index(Model model) {
		// bidRequests
		model.addAttribute("bidRequests", this.bidRequestService.listIndex(5));
		return "main";
	}

	/**
	 * 投资列表的框框
	 */
	@RequestMapping("invest")
	public String investIndex() {
		return "invest";
	}

	/**
	 * 投资列表明细
	 * 此处不用ModelAttribute，是因为上面一部分的网页不需要回显
	 */
	@RequestMapping("invest_list")
	public String investList(BidRequestQueryObject qo, Model model) {
		if (qo.getBidRequestState() == -1) {
			qo.setBidRequestStates(new int[] {
					BidConst.BIDREQUEST_STATE_BIDDING,
					BidConst.BIDREQUEST_STATE_PAYING_BACK,
					BidConst.BIDREQUEST_STATE_COMPLETE_PAY_BACK });
		}
		model.addAttribute("pageResult", this.bidRequestService.query(qo));
		return "invest_list";
	}

}
