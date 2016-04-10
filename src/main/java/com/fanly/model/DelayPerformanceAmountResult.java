package com.fanly.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
*@author fanly
*@email fanly1987444@126.com
*/
public class DelayPerformanceAmountResult {
	public Date startDate;
	public Date endDate;
	public double totalResult;
	public List<DelayPerformanceAmountPart> parts;
	
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		return "从" + format.format(startDate) +
				"~" + format.format(endDate) + 
				 "延迟处罚金总额为：" + totalResult;
	}
}
