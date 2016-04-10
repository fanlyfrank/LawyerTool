package com.fanly.model;

import java.text.ParseException;
import java.util.Date;

/**
*@author
*/
public interface Caculater {

public DelayPerformanceAmountResult caculateDelayPerformanceAmount(Date startDate, Date endDate, double princeple) throws ParseException;

}
