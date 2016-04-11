package com.fanly.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LoanRateServiceImpl extends AbstractRateService implements LoanRateService {


	public double getLoanRate(Date startDate, long diffDays) throws ParseException {
		
		double rate = 0.00d;
		
		long coefficient = diffDays / 360;

		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");

		if (startDate.compareTo(format.parse("2014.08.01")) == 0) {
		
			rate = 0.000175;
		
		} else if (startDate.compareTo(format.parse("2012.07.06")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0560d, 0.0600d, 0.0615d, 0.0640d, 0.0655d);
		
		} else if (startDate.compareTo(format.parse("2012.06.08")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0585d, 0.0631d, 0.0640d, 0.0665d, 0.0680d);
		
		} else if (startDate.compareTo(format.parse("2012.07.06")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0560d, 0.0600d, 0.0615, 0.0640, 0.0655);
		
		} else if (startDate.compareTo(format.parse("2011.07.07")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0610d, 0.0656d, 0.0665d, 0.0690d, 0.0705d);
		
		} else if (startDate.compareTo(format.parse("2011.04.06")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0585d, 0.0631d, 0.0640d, 0.0665d, 0.0680d);
		
		} else if (startDate.compareTo(format.parse("2011.02.09")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0560d, 0.0606d, 0.0610d, 0.0645d, 0.0660d);
		
		} else if (startDate.compareTo(format.parse("2010.12.26")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0535d, 0.0581d, 0.0585d, 0.0622d, 0.0640d);
		
		} else if (startDate.compareTo(format.parse("2010.10.20")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0510d, 0.0556d, 0.0560d, 0.0596d, 0.0614d);
		
		} else if (startDate.compareTo(format.parse("2008.12.23")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0486d, 0.0531d, 0.0540d, 0.0576d, 0.0594d);
		
		} else if (startDate.compareTo(format.parse("2008.11.27")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0504d, 0.0558d, 0.0567d, 0.0594d, 0.0612d);
		
		} else if (startDate.compareTo(format.parse("2008.10.30")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0603d, 0.0666d, 0.0675d, 0.0702d, 0.0720d);
		
		} else if (startDate.compareTo(format.parse("2008.10.09")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0612d, 0.0693d, 0.0702d, 0.0729d, 0.0747d);
		
		} else if (startDate.compareTo(format.parse("2008.09.16")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0621d, 0.0720d, 0.0729d, 0.0756d, 0.0774d);
		
		} else if (startDate.compareTo(format.parse("2007.12.21")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0657d, 0.0747d, 0.0756d, 0.0774d, 0.0783d);
		
		} else if (startDate.compareTo(format.parse("2007.09.15")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0648d, 0.0729d, 0.0747d, 0.0765d, 0.0783d);
		
		} else if (startDate.compareTo(format.parse("2007.08.22")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0621d, 0.0702d, 0.0720d, 0.0738d, 0.0756d);
		
		} else if (startDate.compareTo(format.parse("2007.07.21")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0603d, 0.0684d, 0.0702d, 0.0720d, 0.0738d);
		
		}  else if (startDate.compareTo(format.parse("2007.05.19")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0585d, 0.0657d, 0.0675d, 0.0693d, 0.0720d);
		
		} else if (startDate.compareTo(format.parse("2007.03.18")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0567d, 0.0639d, 0.0657d, 0.0675d, 0.0711d);
		
		} else if (startDate.compareTo(format.parse("2006.08.19")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0558d, 0.0612d, 0.0630d, 0.0648d, 0.0684d);
		
		} else if (startDate.compareTo(format.parse("2006.04.28")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0540d, 0.0585d, 0.0603d, 0.0612d, 0.0639d);
		
		} else if (startDate.compareTo(format.parse("2004.10.29")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0522d, 0.0558d, 0.0576d, 0.0585d, 0.0612d);
		
		} else if (startDate.compareTo(format.parse("2002.02.21")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0504d, 0.0531d, 0.0549d, 0.0558d, 0.0576d);
		
		} else if (startDate.compareTo(format.parse("1999.06.10")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0558d, 0.0585d, 0.0594d, 0.0603d, 0.0621d);
		
		} else if (startDate.compareTo(format.parse("1998.12.07")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0612d, 0.0639d, 0.0666d, 0.0720d, 0.0756d);
		
		}  else if (startDate.compareTo(format.parse("1998.07.01")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0657d, 0.0693d, 0.0711d, 0.0765d, 0.0801d);
		
		} else if (startDate.compareTo(format.parse("1998.03.25")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0702d, 0.0792d, 0.0900d, 0.0972d, 0.1035d);
		
		} else if (startDate.compareTo(format.parse("1997.10.23")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0765d, 0.0864d, 0.0936d, 0.0990d, 0.1053d);
		
		} else if (startDate.compareTo(format.parse("1996.08.23")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0918d, 0.1008d, 0.1098d, 0.1170d, 0.1242d);
		
		} else if (startDate.compareTo(format.parse("1996.05.01")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0972d, 0.1098d, 0.1314d, 0.1494d, 0.1512d);
		
		} else if (startDate.compareTo(format.parse("1995.07.01")) == 0) {	
			
			rate = this.getRate(coefficient, 0.1008d, 0.1206d, 0.1350d, 0.1512d, 0.1530d);
		
		} else if (startDate.compareTo(format.parse("1995.01.01")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0900d, 0.1098d, 0.1296d, 0.1458d, 0.1476d);
		
		} else if (startDate.compareTo(format.parse("1993.07.11")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0900d, 0.1098d, 0.1224d, 0.1386d, 0.1404d);
		
		} else if (startDate.compareTo(format.parse("1993.05.15")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0882d, 0.0936d, 0.1080d, 0.1206d, 0.1224d);
		
		} else if (startDate.compareTo(format.parse("1991.04.21")) == 0) {	
			
			rate = this.getRate(coefficient, 0.0810d, 0.08614d, 0.0900d, 0.0954d, 0.0972d);
		
		}
		
		return rate;
	}
	
	private double getRate(long coefficient, double rate1, double rate2, double rate3, double rate4, double rate5) {
		
		double rate;
		
		if (coefficient <= 0.5) {
			rate = rate1; 
		} else if (coefficient > 0.5 && coefficient <= 1) {
			rate = rate2;
		} else if (coefficient > 1 && coefficient <= 3) {
			rate = rate3;
		} else if (coefficient > 3 && coefficient <=5) {
			rate = rate4;
		} else {
			rate = rate5;
		}
		
		return rate;
	}
	
	protected List<Date> getInflectionPointDates() throws ParseException {
		
		ArrayList<Date> result = new ArrayList<Date>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		
		result.add(format.parse("2014.08.01"));
		result.add(format.parse("2012.07.06"));
		result.add(format.parse("2012.06.08"));
		result.add(format.parse("2011.07.07"));
		result.add(format.parse("2011.04.06"));
		result.add(format.parse("2011.02.09"));
		result.add(format.parse("2010.12.26"));
		result.add(format.parse("2010.10.20"));
		result.add(format.parse("2008.12.23"));
		result.add(format.parse("2008.11.27"));
		result.add(format.parse("2008.10.30"));
		result.add(format.parse("2008.10.09"));
		result.add(format.parse("2008.09.16"));
		result.add(format.parse("2007.12.21"));
		result.add(format.parse("2007.09.15"));
		result.add(format.parse("2007.08.22"));
		result.add(format.parse("2007.07.21"));
		result.add(format.parse("2007.05.19"));
		result.add(format.parse("2007.03.18"));
		result.add(format.parse("2006.08.19"));
		result.add(format.parse("2006.04.28"));
		result.add(format.parse("2004.10.29"));
		result.add(format.parse("2002.02.21"));
		result.add(format.parse("1999.06.10"));
		result.add(format.parse("1998.12.07"));
		result.add(format.parse("1997.10.23"));
		result.add(format.parse("1996.08.23"));
		result.add(format.parse("1996.05.01"));
		result.add(format.parse("1995.07.01"));
		result.add(format.parse("1995.01.01"));
		result.add(format.parse("1993.07.11"));
		result.add(format.parse("1993.05.15"));
		result.add(format.parse("1991.04.21"));
		
		return result;
	}

}
