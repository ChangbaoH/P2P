package com.hcb.p2p.base.mapper;

import com.hcb.p2p.base.domain.VedioAuth;
import com.hcb.p2p.base.query.VedioAuthQueryObject;

import java.util.List;

public interface VedioAuthMapper {
    int insert(VedioAuth record);

    VedioAuth selectByPrimaryKey(Long id);

    /**
     * 查询相关
     */
    int queryForCount(VedioAuthQueryObject qo);

    List<VedioAuth> query(VedioAuthQueryObject qo);
}