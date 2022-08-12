package com.hcb.p2p.base.mapper;
import com.hcb.p2p.base.domain.Userinfo;
import java.util.List;
import java.util.Map;

public interface UserinfoMapper {
    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Userinfo record);

    //mybatisX检查报错
    List<Map<String, Object>> autocomplate(String keyword);

}