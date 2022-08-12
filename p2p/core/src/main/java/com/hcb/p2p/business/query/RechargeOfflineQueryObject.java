package com.hcb.p2p.business.query;

import com.hcb.p2p.base.query.AuditQueryObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;


/**
 * 线下充值查询
 * 
 * @author Administrator
 * 
 */
@Getter
@Setter
public class RechargeOfflineQueryObject extends AuditQueryObject {

	private Long applierId;
	private long bankInfoId = -1;// 按照开户行查询
	private String tradeCode;

	public String getTradeCode() {
		return StringUtils.hasLength(tradeCode) ? tradeCode : null;
	}
}
