package com.fanly.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
*@author fanly
*@email fanly1987444@126.com
*/
public class DelayPerformanceAmountPart {

	public Date startDate;
	public Date endDate;
	public long diffDays;
	public double rate;
	public double amount;
	
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		return format.format(startDate) + "~" +
				format.format(endDate) + ":" +
				 "共" + diffDays + "天" + "-" +
				   "利率为：" + rate + "-" +
				   	 "金额为：" + amount;
	}
}
