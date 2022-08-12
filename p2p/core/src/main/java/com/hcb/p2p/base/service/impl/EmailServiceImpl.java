package com.hcb.p2p.base.service.impl;

import com.hcb.p2p.base.domain.RealAuth;
import com.hcb.p2p.base.event.RealAuthSuccessEvent;
import com.hcb.p2p.base.service.IEmailService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements IEmailService,
		ApplicationListener<RealAuthSuccessEvent> {

	@Override
	public void onApplicationEvent(RealAuthSuccessEvent event) {
		this.sendEmail(event.getRealAuth());
	}

	private void sendEmail(RealAuth realAuth) {
		System.out.println("用户" + realAuth.getApplier().getUsername()
				+ " 实名认证成功,发送邮件");
	}

}
