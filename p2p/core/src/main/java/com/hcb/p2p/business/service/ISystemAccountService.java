package com.hcb.p2p.business.service;

import com.hcb.p2p.business.domain.BidRequest;
import com.hcb.p2p.business.domain.MoneyWithdraw;
import com.hcb.p2p.business.domain.PaymentScheduleDetail;
import com.hcb.p2p.business.domain.SystemAccount;

import java.math.BigDecimal;


/**
 * 系统账户相关服务
 * 
 * @author Administrator
 * 
 */
public interface ISystemAccountService {

	void update(SystemAccount systemAccount);

	/**
	 * 检查并初始化系统账户
	 */
	void initAccount();

	/**
	 * 系统账户收到借款管理费
	 * 
	 * @param br
	 * @param manageChargeFee
	 */
	void chargeBorrowFee(BidRequest br, BigDecimal manageChargeFee);

	/**
	 * 系统账户收取提现手续费
	 * 
	 * @param
	 */
	void chargeWithdrawFee(MoneyWithdraw m);

	/**
	 * 系统账户手续利息管理费
	 * 
	 * @param psd
	 * @param interestChargeFee
	 */
	void chargeInterestFee(PaymentScheduleDetail psd,
						   BigDecimal interestChargeFee);
}
