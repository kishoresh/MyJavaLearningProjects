package com.designpattern.creational.factorymethod;
/*
 * A factory class, which depending on the plantype, will create the Plan object and return.
 */

import java.util.Calendar;

public class PlanFactory {

	public Plan getPlan(String planType){
		
		if (planType == null){
			return null;
		}
		if (planType.equalsIgnoreCase("DomesticPlan")){
			return new DomesticPlan();
		}
		if (planType.equalsIgnoreCase("CommercialPlan")){
			return new CommercialPlan();
		}
		if (planType.equalsIgnoreCase("InstituitionalPlan")){
			return new InstitutionalPlan();
		}
		return null;
	}
	
	Calendar cal = Calendar.getInstance();

}
