package com.hcb.p2p.base.query;

import com.hcb.p2p.base.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.util.Date;



/**
 * 登陆日志查询对象
 * 
 * @author Administrator
 * 
 */
@Setter
@Getter
public class IplogQueryObject extends QueryObject {

	private Date beginDate;
	private Date endDate;
	private int state = -1;
	private String username;
	private int userType = -1;

	/**
	 * 因为IpLogQueryObject里面的参数都是直接让SpringMVC注入进来的 如果没有配置日期的格式,SpringMVC没法注入日期;
	 * 所以,最简单的办法,通过添加@DateTimeFormat标签来告诉SpringMVC日期的注入格式
	 * 
	 * @param beginDate
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	//得到一天的最后一秒钟
	public Date getEndDate() {
		return endDate == null ? null : DateUtil.endOfDay(endDate);
	}

	//username是否为空
	public String getUsername() {
		return StringUtils.hasLength(username) ? username : null;
	}

}
