package com.hcb.mgrsite.base;

import com.hcb.p2p.base.domain.SystemDictionary;
import com.hcb.p2p.base.domain.SystemDictionaryItem;
import com.hcb.p2p.base.query.SystemDictionaryQueryObject;
import com.hcb.p2p.base.service.ISystemDictionaryService;
import com.hcb.p2p.base.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 数据字典相关
 * 
 * @author Administrator
 * 
 */
@Controller
public class SystemDictionaryController {

	@Autowired
	private ISystemDictionaryService systemDictionaryService;

	/**
	 * 数据字典分类列表
	 * 
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("systemDictionary_list")
	public String systemDictionaryList(
			@ModelAttribute("qo") SystemDictionaryQueryObject qo, Model model) {
		model.addAttribute("pageResult",
				this.systemDictionaryService.queryDics(qo));
		return "systemdic/systemDictionary_list";
	}

	/**
	 * 添加/修改数据字典
	 */
	@RequestMapping("systemDictionary_update")
	@ResponseBody
	public JSONResult systemDictionaryUpdate(SystemDictionary dictionary) {
		this.systemDictionaryService.saveOrUpdateDic(dictionary);
		return new JSONResult();
	}

	/**
	 * 明细列表
	 */
	@RequestMapping("systemDictionaryItem_list")
	public String systemDictionaryItemList(
			@ModelAttribute("qo") SystemDictionaryQueryObject qo, Model model) {
		model.addAttribute("pageResult",
				this.systemDictionaryService.queryItems(qo));
		model.addAttribute("systemDictionaryGroups",this.systemDictionaryService.listAllDics());
		return "systemdic/systemDictionaryItem_list";
	}
	
	/**
	 * 添加修改字典明细
	 */
	@RequestMapping("systemDictionaryItem_update")
	@ResponseBody
	public JSONResult systemDictionaryItemUpdate(SystemDictionaryItem item) {
		this.systemDictionaryService.saveOrUpdateItem(item);
		return new JSONResult();
	}
}
