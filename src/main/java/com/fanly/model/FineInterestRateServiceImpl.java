package com.fanly.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FineInterestRateServiceImpl extends AbstractRateService implements FineInterestRateService {

	public double getFineRate(Date startDate, long diffDays, double maxRate, double minRate) throws ParseException {
		
		double rate = 0.00d;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		
		if (startDate.compareTo(format.parse("2004.01.01")) == 0) {
			rate = maxRate;
		} else if (startDate.compareTo(format.parse("1999.06.10")) == 0) {
			rate = 0.000210;
		} else if (startDate.compareTo(format.parse("1998.12.07")) == 0) {
			rate = 0.000300;
		} else if (startDate.compareTo(format.parse("1996.05.01")) == 0) {
			rate = 0.000400;
		} else if (startDate.compareTo(format.parse("1995.07.01")) == 0) {
			rate = minRate;
		} 
		
		return rate;
	}
	
	protected List<Date> getInflectionPointDates() throws ParseException {
		
		ArrayList<Date> result = new ArrayList<Date>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		
		result.add(format.parse("2004.01.01"));
		result.add(format.parse("1999.06.10"));
		result.add(format.parse("1998.12.07"));
		result.add(format.parse("1996.05.01"));
		result.add(format.parse("1995.07.01"));
		
		return result;
	}
}
