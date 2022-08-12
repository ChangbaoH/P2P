package com.hcb.p2p.base.service;


import com.hcb.p2p.base.query.IplogQueryObject;
import com.hcb.p2p.base.query.PageResult;

public interface IIplogService {

	/**
	 * 分页查询
	 * 
	 * @param qo
	 * @return
	 */
	PageResult query(IplogQueryObject qo);
}
