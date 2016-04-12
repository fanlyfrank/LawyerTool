package com.fanly.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fanly.model.Caculater;
import com.fanly.model.DivisibleAmountResult;

@Controller
@RequestMapping("/caculate")
public class CaculateConroller {

	@Autowired
	private Caculater caculater;

	@RequestMapping("/delayPerformance")
	@ResponseBody
	public Object caculateDelayPerformanceAmount(Date startDate, Date endDate, double princeple) {

		DivisibleAmountResult result = null;
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			result = caculater.caculateDelayPerformanceAmount(startDate, endDate, princeple);
			
			resultMap.put("result", "1");
			resultMap.put("obj", result);
			
		} catch (ParseException e) {
			
			resultMap.put("result", "0");
			resultMap.put("obj", e);
		}

		return resultMap;
	}
	
	@RequestMapping("/fineInterest")
	public Object caculateFineInterestAmount(Date startDate, Date endDate, double princeple, double maxRate, double minRate) {
		
		DivisibleAmountResult result = null;
		
		try {
			result = caculater.caculateFineInterestAmount(startDate, endDate, princeple, maxRate, minRate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

	public class DateEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			Date date = null;
			try {
				date = format.parse(text);
			} catch (ParseException e) {
				format = new SimpleDateFormat("yyyy.MM.dd");
				try {
					date = format.parse(text);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			setValue(date);
		}
	}
}
