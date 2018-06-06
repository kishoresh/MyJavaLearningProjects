package com.designpattern.creational.factorymethod;

import java.io.IOException;

public class GenerateBill {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String[] planNames = {"DomesticPlan","CommercialPlan","InstituitionalPlan"};
        int units = 100;

        PlanFactory planFactory = new PlanFactory();

		Plan p = planFactory.getPlan(planNames[0]);
        p.setRate(5.3);
        p.calculateBill(units);

        p = planFactory.getPlan(planNames[1]);
        p.setRate(6.3);
        p.calculateBill(units);

        p = planFactory.getPlan(planNames[2]);
        p.setRate(7.5);
        p.calculateBill(units);

	}

}
