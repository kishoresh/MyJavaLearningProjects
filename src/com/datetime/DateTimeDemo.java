package com.datetime;

import java.nio.channels.NonWritableChannelException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeDemo {

	public static void main(String[] args) {
		//LocalDate
		LocalDate date = LocalDate.now();
		LocalDate yesterday = date.minusDays(1);
		LocalDate tomorrow  = date.plusDays(1);
				
		System.out.println("Today : " + date);
		System.out.println("Yesterday : " + yesterday);
		System.out.println("Tomorrow : " + tomorrow);
		
		LocalDate date2 = LocalDate.of(2017, 11, 3);
		System.out.println("Date is : " +date2.isLeapYear());
		
		//LocalDateTime
		LocalDateTime datetime = LocalDateTime.now();
		System.out.println("DateTime Now : " + datetime);
		LocalDateTime dt2 = date.atTime(11, 25, 45);
		System.out.println("DateTime : " + dt2);
		
		//DateTimeFormatter
		DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
		String formatedDt = datetime.format(dtformatter);
		System.out.println("Formatted date time : " + formatedDt);
		
		//LocalTime
		LocalTime lt = LocalTime.now();
		LocalTime lt1 = lt.minusHours(2);
		LocalTime lt2 = lt.plusMinutes(20);
		System.out.println(lt1);
		System.out.println(lt2);

		//TimeZone - Diff between 2 timezones in Hrs & moins.
		ZoneId z1 = ZoneId.of("Asia/Kolkata");
		ZoneId z2 = ZoneId.of("Asia/Tokyo");
		LocalTime l1 = LocalTime.now(z1);
		LocalTime l2 = LocalTime.now(z2);
		System.out.println("Time in Kolkata : " +l1 + " and Time in Tokyo : " + l2);
		long hrs = ChronoUnit.HOURS.between(l1, l2);
		System.out.println("Diff between 2 time zone is " + hrs);
		long mins = ChronoUnit.MINUTES.between(l1, l2);
		System.out.println("Diff between 2 time zone is " + mins);
		
		//Get method with ChronoField
		LocalDateTime a = LocalDateTime.of(2017, 11, 12, 12, 30);
		System.out.println(a.get(ChronoField.DAY_OF_WEEK));
		System.out.println(a.get(ChronoField.DAY_OF_YEAR));
		
	}

}
