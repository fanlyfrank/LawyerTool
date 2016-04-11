package com.fanly.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public interface LoanRateService {

	public ArrayList<Date> getInsertedInflectionPointDates(Date startDate, Date endDate);
	
	public double getLoanRate (Date startDate, long diffDays) throws ParseException;

}
