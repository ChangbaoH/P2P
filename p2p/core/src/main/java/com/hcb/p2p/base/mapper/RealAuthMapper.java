package com.hcb.p2p.base.mapper;

import com.hcb.p2p.base.domain.RealAuth;
import com.hcb.p2p.base.query.RealAuthQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface RealAuthMapper {
/*    int insert(@Param("ra")RealAuth record,@Param("key")String key);*/

    int insert(@Param("ra")RealAuth record,@Param("key")String key,@Param("id")Long id);
    RealAuth selectByPrimaryKey(@Param("id")Long id,@Param("key")String key);

    int updateByPrimaryKey(RealAuth record);

    /**
     * 后台审核分页查询相关
     */
    int queryForCount(@Param("qo")RealAuthQueryObject qo,@Param("key")String key);

    List<RealAuth> query(@Param("qo")RealAuthQueryObject qo,@Param("key")String key);
}