package com.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {

	public static void main(String[] args) {
		Date dt = new Date();
		//DateFormat
		System.out.println(DateFormat.getInstance().format(dt));
		System.out.println(DateFormat.getDateInstance().format(dt));
		System.out.println(DateFormat.getTimeInstance().format(dt));
		
	
		//Date formatter using SimpleDateFormat - Date to String
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Formated date : " + sdf.format(dt));

		sdf = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Date [dd-MM-yyyy] : " + sdf.format(dt));
		
		sdf = new SimpleDateFormat("E, dd MMMM YYYY HH:mm:ss zzzz");
		System.out.println("Date [E, dd MMMM yyyy HH:mm:ss zzzz] : " + sdf.format(dt));
		
		//Date formatter using SimpleDateFormat - String to Date
		try{
			sdf = new SimpleDateFormat("dd/MM/yy");
			Date date = sdf.parse("21/01/1073");
			System.out.println("Parse date : " + date);
		}catch(ParseException e){
			e.printStackTrace();
		}
		
	}

}
