package com.hcb.p2p.base.mapper;

import com.hcb.p2p.base.domain.SystemDictionaryItem;
import com.hcb.p2p.base.query.SystemDictionaryQueryObject;

import java.util.List;

public interface SystemDictionaryItemMapper {
    int insert(SystemDictionaryItem record);

    SystemDictionaryItem selectByPrimaryKey(Long id);

    int updateByPrimaryKey(SystemDictionaryItem record);

    /**
     * 分页相关的查询
     */
    int queryForCount(SystemDictionaryQueryObject qo);
    List<SystemDictionaryItem> query(SystemDictionaryQueryObject qo);

    /**
     * 根据数据字典分类sn查询明细
     * @param sn
     * @return
     */
    List<SystemDictionaryItem> listByParentSn(String sn);
}