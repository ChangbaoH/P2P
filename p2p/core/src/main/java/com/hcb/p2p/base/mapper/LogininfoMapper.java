package com.hcb.p2p.base.mapper;

import com.hcb.p2p.base.domain.Logininfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogininfoMapper {

    int insert(Logininfo record);

    Logininfo selectByPrimaryKey(Long id);

    List<Logininfo> selectAll();

    int updateByPrimaryKey(Logininfo record);

    /**
     * 根据用户名查询用户数量
     *
     * @param username
     * @return
     */
    int getCountByUsername(String username);

    /**
     * 登陆
     *
     * @param username
     * @param encode
     * @return
     */
    Logininfo login(@Param("username") String username,
                    @Param("password") String encode, @Param("userType") int userType);

    /**
     * 按照类型查询用户类型数量
     *
     * @param
     * @return
     */
    int countByUserType(int userType);
}
