package com.hcb.p2p.base.mapper;

import com.hcb.p2p.base.domain.UserFile;
import com.hcb.p2p.base.query.UserFileQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFileMapper {
    int insert(UserFile record);

    UserFile selectByPrimaryKey(Long id);

    List<UserFile> selectAll();

    int updateByPrimaryKey(UserFile record);

    /**
     * 列出一个用户风控资料对象 hasType:如果为true,选择有类型的,如果为false,选择没有类型的
     *
     * @param logininfoId
     * @param hasType
     * @return
     */
    List<UserFile> listFilesByHasType(@Param("logininfoId") Long logininfoId,
                                      @Param("hasType") boolean hasType);

    int queryForCount(UserFileQueryObject qo);

    List<UserFile> query(UserFileQueryObject qo);
}