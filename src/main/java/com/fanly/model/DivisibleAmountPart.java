package com.fanly.model;

/**
*@author fanly
*@email fanly1987444@126.com
*/
public class DivisibleAmountPart {

	public String startDate;
	public String endDate;
	public long diffDays;
	public double rate;
	public double amount;
	
	@Override
	public String toString() {

		return "[" + startDate + "~" +
				endDate + "]" + " [" +
				 "days:" + diffDays  + "] [" +
				   "rate:" + rate + "] [" +
				   	 "amount:" + amount + "]";
	}
}
