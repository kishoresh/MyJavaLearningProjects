package com.datetime;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class ClassicalDateDemo {

	public static void main(String[] args) {
		Date dt1 = new Date();
		System.out.println("Current DateTime : " + dt1);
		
		long millis = System.currentTimeMillis();
		Date dt2 = new Date(millis);
		System.out.println("Current DateTime : " + dt2);
		
		//Date dt3 = new Date("2017-11-12");            //We cannot send string as parameter.		
		//Date dt3 = new Date(2017, 11, 16, 09, 18);    //This is deprecated
		
		//java.util.Calendar Factory class usage 
		Calendar cl = Calendar.getInstance();
		System.out.println("The Current date is : " + cl.getTime());
		cl.add(Calendar.DATE, 10);
		System.out.println("The Current date + 10 days is : " + cl.getTime());
		cl.add(Calendar.DATE, -20);
		System.out.println("The Current date - 20 days is : " + cl.getTime());
		System.out.println("Max no of weeks : " + cl.getMaximum(Calendar.WEEK_OF_YEAR));
		cl.add(Calendar.YEAR, 5);
		System.out.println("The Current date + 5 year is : " + cl.getTime());
		System.out.println("Max days in the year : " + cl.getMaximum(Calendar.DAY_OF_YEAR));
		
		int yr = cl.get(Calendar.YEAR);
		int mt = cl.get(Calendar.MONTH);
		int dy = cl.get(Calendar.DAY_OF_MONTH);
		System.out.println("Day = "+dy + " Month = " + mt + " Year = " + yr);		
		
	}

}
