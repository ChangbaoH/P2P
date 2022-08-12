package com.hcb.p2p.base.event;

import com.hcb.p2p.business.domain.RechargeOffline;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: HCB
 * @Description:  充值成功消息对象
 * @Date: 2022-07-14
 */
@Getter
public class RechargeOfflineSuccessEvent extends ApplicationEvent {

	private RechargeOffline ro;

	public RechargeOfflineSuccessEvent(Object source, RechargeOffline ro) {
		super(source);
		this.ro = ro;
	}

}
