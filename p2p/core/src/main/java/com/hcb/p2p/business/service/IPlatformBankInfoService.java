package com.hcb.p2p.business.service;

import com.hcb.p2p.base.query.PageResult;
import com.hcb.p2p.business.domain.PlatformBankInfo;
import com.hcb.p2p.business.query.PlatformBankInfoQueryObject;

import java.util.List;


/**
 * 平台账户服务
 */
public interface IPlatformBankInfoService {

	PageResult query(PlatformBankInfoQueryObject qo);

	void saveOrUpdate(PlatformBankInfo bankInfo);

	List<PlatformBankInfo> listAll();
}
