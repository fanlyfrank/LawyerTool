package com.fanly.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
*@author fanly
*@email fanly1987444@126.com
*/
public class DivisibleAmountResult {
	public Date startDate;
	public Date endDate;
	public double totalResult;
	public List<DivisibleAmountPart> parts;
	
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		return "[" + format.format(startDate) +
				"~" + format.format(endDate) +  
				 "] [amount:" + totalResult + "]";
	}
}
