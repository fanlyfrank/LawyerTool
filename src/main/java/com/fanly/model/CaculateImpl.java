package com.fanly.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*@author fanly
*@email fanly1987444@126.com
*/

@Service
public class CaculateImpl implements Caculater {

	public static void main(String[] args) {
		
		
		try {
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
			
			Date start = format.parse("1996.04.10");
			
			Date end = format.parse("2016.04.11");
			
			CaculateImpl c = new CaculateImpl();
			c.loanRateService = new LoanRateServiceImpl();
			c.fineInterestRateService = new FineInterestRateServiceImpl();
			
			//c.getInsertedInflectionPointDates(start, end);
			
			//c.caculateDelayPerformanceAmount(start, end, 50000);
			c.caculateFineInterestAmount(start, end, 50000, 0.00053, 0.0005);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Autowired
	public LoanRateService loanRateService;
	
	@Autowired
	public FineInterestRateService fineInterestRateService;
	
	
	public DivisibleAmountResult caculateDelayPerformanceAmount(Date startDate, Date endDate, double princeple) throws ParseException {
		
		DivisibleAmountResult result = new DivisibleAmountResult();
		
		result.startDate = startDate;
		result.endDate = endDate;
		
		List<Date> dates = loanRateService.getInsertedInflectionPointDates(startDate, endDate);
		ArrayList<DivisibleAmountPart> parts = new ArrayList<DivisibleAmountPart>();
		
		for (int i = 0; i < dates.size() - 1; i++) {
			
			Date maxDate;
			Date minDate = dates.get(i + 1);
			
			if (i == 0) {
				
				maxDate = dates.get(i);
				
			} else {
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dates.get(i));
				calendar.add(Calendar.DATE, -1);
				maxDate = calendar.getTime();
			
			}
			
			long diff = maxDate.getTime() - minDate.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			DivisibleAmountPart part = new DivisibleAmountPart();
			
			part.startDate = maxDate;
			part.endDate = minDate;
			part.diffDays = diffDays;
			part.rate = loanRateService.getLoanRate(minDate, diffDays);
			
			if (part.rate == 0) {
				part.rate = loanRateService.getLoanRate(dates.get(i + 2), diffDays);
				part.amount = princeple * part.diffDays * part.rate / 360;
				
				System.out.println(part);
				parts.add(part);
				result.totalResult += part.amount;
				break;
				
			} else if (part.rate == 0.000175) {
				
				part.amount = princeple * part.diffDays * part.rate;
				
			} else {
				
				part.amount = princeple * part.diffDays * part.rate / 360;
				
			}
			
			System.out.println(part);
			parts.add(part);
			result.totalResult += part.amount;
		}
		
		result.parts = parts;
		
		System.out.println(result);
		return result;
	}
	
	public DivisibleAmountResult caculateFineInterestAmount(Date startDate, Date endDate, double princeple, double maxRate, double minRate) throws ParseException {
		
		DivisibleAmountResult result = new DivisibleAmountResult();
		
		result.startDate = startDate;
		result.endDate = endDate;
		
		List<Date> dates = fineInterestRateService.getInsertedInflectionPointDates(startDate, endDate);
		ArrayList<DivisibleAmountPart> parts = new ArrayList<DivisibleAmountPart>();
		
		for (int i = 0; i < dates.size() - 1; i++) {
			
			Date maxDate;
			Date minDate = dates.get(i + 1);
			
			if (i == 0) {
				
				maxDate = dates.get(i);
				
			} else {
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dates.get(i));
				calendar.add(Calendar.DATE, -1);
				maxDate = calendar.getTime();
			
			}
			
			long diff = maxDate.getTime() - minDate.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			DivisibleAmountPart part = new DivisibleAmountPart();
			
			part.startDate = maxDate;
			part.endDate = minDate;
			part.diffDays = diffDays;
			part.rate = fineInterestRateService.getFineRate(minDate, diffDays, maxRate, minRate);
			
			if (part.rate == 0) {
				
				part.rate = fineInterestRateService.getFineRate(dates.get(i + 2), diffDays, maxRate, minRate);
				part.amount = princeple * part.diffDays * part.rate;
				
				System.out.println(part);
				parts.add(part);
				result.totalResult += part.amount;
				break;
				
			} else {
				
				part.amount = princeple * part.diffDays * part.rate;
				
			}
			
			System.out.println(part);
			parts.add(part);
			result.totalResult += part.amount;
		}
		
		result.parts = parts;
		
		System.out.println(result);
		
		return result;
	}
	
	public double caculateMaintenamceCosts(double princeple, long count) {
		double result = 0.00d;
		
		if	(princeple < 1000) {
			result = count * 30;
		} else if (princeple >= 1000 && princeple < 100000) {
			result = princeple * 0.01;
		} else if (princeple >= 100000) {
			result = princeple * 0.005;
			result = Math.max(result, 5000);
		}
		
		return result;
	}
	
	public double caculateExecutionFees(double princeple, long count) {
		double result = 0.00d;
		
		if (princeple <= 0) {
			
		}
		return result;
	}
}
