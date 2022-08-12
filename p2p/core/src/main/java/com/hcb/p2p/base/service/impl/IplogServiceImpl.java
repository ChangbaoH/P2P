package com.hcb.p2p.base.service.impl;

import com.hcb.p2p.base.domain.Iplog;
import com.hcb.p2p.base.mapper.IplogMapper;
import com.hcb.p2p.base.query.IplogQueryObject;
import com.hcb.p2p.base.query.PageResult;
import com.hcb.p2p.base.service.IIplogService;
import com.hcb.p2p.base.util.BidConst;
import com.hcb.p2p.base.util.DataSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class IplogServiceImpl implements IIplogService {

	@Autowired
	private IplogMapper iplogMapper;

	@Override
	public PageResult query(IplogQueryObject qo) {
		DataSourceContext.set(BidConst.SALVE_DS);
		int count = this.iplogMapper.queryForCount(qo);
		if (count > 0) {
			List<Iplog> list = this.iplogMapper.query(qo);
			return new PageResult(list, count, qo.getCurrentPage(),
					qo.getPageSize());
		}
		return PageResult.empty(qo.getPageSize());
	}

}
