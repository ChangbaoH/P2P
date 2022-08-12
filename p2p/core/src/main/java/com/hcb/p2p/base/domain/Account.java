package com.hcb.p2p.base.domain;

import com.hcb.p2p.base.util.BidConst;
import com.hcb.p2p.base.util.MD5;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 用户对应的账户信息
 *
 * @author Administrator
 *
 */
@Setter
@Getter
public class Account extends BaseDomain {

	private int version;
	private String tradePassword;//交易密码
	private BigDecimal usableAmount = BidConst.ZERO;//可用余额
	private BigDecimal freezedAmount = BidConst.ZERO;//冻结金额
	private BigDecimal unReceiveInterest = BidConst.ZERO;//代收利息
	private BigDecimal unReceivePrincipal = BidConst.ZERO;//代收本金
	private BigDecimal unReturnAmount = BidConst.ZERO;//待还金额
	private BigDecimal remainBorrowLimit = BidConst.INIT_BORROW_LIMIT;//剩余授信额度
	private BigDecimal borrowLimit = BidConst.INIT_BORROW_LIMIT;//授信额度

	private String verifyCode;// 做数据校验的

	public String getVerifyCode() {
		return MD5.encode(usableAmount.hashCode() + " "
				+ freezedAmount.hashCode());
	}

	public boolean checkVerifyCode() {

		System.out.println(MD5.encode(
				usableAmount.hashCode() + " " + freezedAmount.hashCode()));
		return MD5.encode(
				usableAmount.hashCode() + " " + freezedAmount.hashCode())
				.equals(verifyCode);
	}

	public BigDecimal getTotalAmount() {
		return usableAmount.add(this.freezedAmount)
				.add(this.unReceivePrincipal);
	}

}
