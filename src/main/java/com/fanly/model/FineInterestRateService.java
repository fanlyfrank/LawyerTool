package com.fanly.model;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface FineInterestRateService {

	public List<Date> getInsertedInflectionPointDates(Date startDate, Date endDate);
	
	public double getFineRate(Date startDate, long diffDays, double maxRate, double minRate) throws ParseException;
}
