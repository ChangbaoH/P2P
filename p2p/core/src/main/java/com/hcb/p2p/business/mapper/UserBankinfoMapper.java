package com.hcb.p2p.business.mapper;

import com.hcb.p2p.business.domain.UserBankinfo;

public interface UserBankinfoMapper {

	int insert(UserBankinfo record);

	UserBankinfo selectByUser(Long userid);

}