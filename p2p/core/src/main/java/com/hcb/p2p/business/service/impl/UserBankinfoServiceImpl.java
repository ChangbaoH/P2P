package com.hcb.p2p.business.service.impl;

import com.hcb.p2p.base.domain.Userinfo;
import com.hcb.p2p.base.service.IUserinfoService;
import com.hcb.p2p.base.util.BitStatesUtils;
import com.hcb.p2p.base.util.UserContext;
import com.hcb.p2p.business.domain.UserBankinfo;
import com.hcb.p2p.business.mapper.UserBankinfoMapper;
import com.hcb.p2p.business.service.IUserBankinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBankinfoServiceImpl implements IUserBankinfoService {

	@Autowired
	private UserBankinfoMapper userBankinfoMapper;

	@Autowired
	private IUserinfoService userinfoService;

	@Override
	public UserBankinfo getByUser(Long id) {
		return this.userBankinfoMapper.selectByUser(id);
	}

	@Override
	public void bind(UserBankinfo bankInfo) {
		// 判断当前用户没有绑定;
		Userinfo current = this.userinfoService.getCurrent();
		if (!current.getIsBindBank() && current.getIsRealAuth()) {
			// 创建一个UserBankinfo,设置相关属性;
			UserBankinfo b = new UserBankinfo();
			b.setAccountName(current.getRealName());
			b.setAccountNumber(bankInfo.getAccountNumber());
			b.setBankForkName(bankInfo.getBankForkName());
			b.setBankName(bankInfo.getBankName());
			b.setLogininfo(UserContext.getCurrent());
			this.userBankinfoMapper.insert(b);
			// 修改用户状态码
			current.addState(BitStatesUtils.OP_BIND_BANKINFO);
			this.userinfoService.update(current);
		}
	}
	
	

}
