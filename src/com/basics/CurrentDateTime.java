package com.basics;
/*
 * What are the diff ways in which we can get hte current Date Time.
 * DateTimeFormatter is introduced in Java 8 in java.time.format package.
 * It have a significant performance improvement over SimpleDateFormat.
 * Diff ways in which we can display the current data & time :
 * 1. Using java.util.Date - Date()
 * 2. Using java.util.Calendar - Calendar.getTime()
 * 3. Using java.time.LocalDateTime - LocalDateTime.now()
 * 4. Using java.time.LocalDate - LocalDate.now()
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CurrentDateTime {
	public static final DateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
	
	public static void main(String[] args) {
		//1. Using java.util.Date - Date()
		Date dt = new Date();
		System.out.println("Current date using Date : " + sdf.format(dt));
		
		//2. Using java.util.Calendar - Calendar.getTime()
		Calendar cal = Calendar.getInstance();
		System.out.println("Current date using Calendar : " + sdf.format(cal.getTime()));
		
		//3. Using java.time.LocalDateTime - LocalDateTime.now() 
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Current date using LocalDateTime : " + dtf.format(now) );
		
		//4. Using java.time.LocalDate - LocalDate.now() 
		LocalDate localDate = LocalDate.now();
		System.out.println("Current date using LocalDate : " + dtf.ofPattern("YYYY-MM-dd").format(localDate) );
	}

}
