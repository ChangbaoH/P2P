package com.hcb.p2p.business.mapper;

import com.hcb.p2p.business.domain.RechargeOffline;
import com.hcb.p2p.business.query.RechargeOfflineQueryObject;

import java.util.List;

public interface RechargeOfflineMapper {
    int insert(RechargeOffline record);

    RechargeOffline selectByPrimaryKey(Long id);

    int updateByPrimaryKey(RechargeOffline record);

    int queryForCount(RechargeOfflineQueryObject qo);

    List<RechargeOffline> query(RechargeOfflineQueryObject qo);
}