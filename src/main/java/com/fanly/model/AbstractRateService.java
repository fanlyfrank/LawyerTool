package com.fanly.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public abstract class AbstractRateService {

	public ArrayList<Date> getInsertedInflectionPointDates(Date startDate, Date endDate) {
		ArrayList<Date> result = new ArrayList<Date>();
		
		try {
			
			List<Date> inflectionPointDates = this.getInflectionPointDates();
			
			result.add(endDate);
			
			int j = -1;
			
			for(int i = 0; i < inflectionPointDates.size(); i++) {
				
				Date date = inflectionPointDates.get(i);
				
				if	(date.after(startDate) && date.before(endDate)) {
				
					result.add(date);
				
				} else {
					
					if (date.before(startDate) && j == -1) {
						j = i;
					}
					
					continue;
				}
				
			}
			
			result.add(startDate);
			
			if (j != -1) {
				Date minDate = inflectionPointDates.get(j);
				result.add(minDate);
			}
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
			for (Date date : result) {
				System.out.println(format.format(date));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		return result;
	}
	
	abstract protected List<Date> getInflectionPointDates() throws ParseException;
}
