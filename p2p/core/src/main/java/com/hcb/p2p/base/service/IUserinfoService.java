package com.hcb.p2p.base.service;

import com.hcb.p2p.base.domain.Userinfo;

import java.util.List;
import java.util.Map;


/**
 * 用户相关信息服务
 *
 * @author Administrator
 *
 */
public interface IUserinfoService {

	/**
	 * 乐观锁支持
	 *
	 * @param userinfo
	 */
	void update(Userinfo userinfo);

	/**
	 * 添加userinfo
	 *
	 * @param ui
	 */
	void add(Userinfo ui);

	Userinfo get(Long id);

	/**
	 * 绑定手机号
	 *
	 * @param phoneNumber
	 * @param verifyCode
	 */
	void bindPhone(String phoneNumber, String verifyCode);

	/**
	 * 发送绑定邮箱邮件
	 *
	 * @param email
	 */
	void sendVerifyEmail(String email);

	/**
	 * 得到当前的userinfo对象
	 *
	 * @return
	 */
	Userinfo getCurrent();

	/**
	 * 执行邮箱绑定
	 *
	 * @param uuid
	 */
	void bindEmail(String uuid);

	/**
	 * 更新用户基本数据
	 *
	 * @param userinfo
	 */
	void updateBasicInfo(Userinfo userinfo);

	/**
	 * 用于用户的autcomplate
	 * 返回的MAP:{id:logininfoId,username:username}
	 * @param keyword
	 * @return
	 */
	List<Map<String, Object>> autoComplate(String keyword);
}
