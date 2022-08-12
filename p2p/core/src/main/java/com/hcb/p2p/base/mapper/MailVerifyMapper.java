package com.hcb.p2p.base.mapper;

import com.hcb.p2p.base.domain.MailVerify;

public interface MailVerifyMapper {

    int insert(MailVerify record);

    /**
     * 根据UUID来查询对应的邮箱验证对象
     *
     * @param uuid
     * @return
     */
    MailVerify selectByUUID(String uuid);
}