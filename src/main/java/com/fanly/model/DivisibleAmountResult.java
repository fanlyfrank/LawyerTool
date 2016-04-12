package com.fanly.model;

import java.util.List;

/**
*@author fanly
*@email fanly1987444@126.com
*/
public class DivisibleAmountResult {
	public String startDate;
	public String endDate;
	public double totalResult;
	public List<DivisibleAmountPart> parts;
	
	@Override
	public String toString() {
		return "[" + startDate +
				"~" + endDate +  
				 "] [amount:" + totalResult + "]";
	}
}
