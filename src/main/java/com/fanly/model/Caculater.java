package com.fanly.model;

import java.text.ParseException;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
*@author
*/

@Service
public interface Caculater {

public DivisibleAmountResult caculateDelayPerformanceAmount(Date startDate, Date endDate, double princeple) throws ParseException;

public DivisibleAmountResult caculateFineInterestAmount(Date startDate, Date endDate, double princeple, double minRate, double maxRate) throws ParseException;
}
