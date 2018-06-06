package com.designpattern.structural.facade;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FacadePatternClient {
	private static int choice;

	public static void main(String[] args) {
		do{
			System.out.println("*************Mobile Shop *************\n");
			System.out.println("      1. IPhone\n");
			System.out.println("      2. Samsung \n");
			System.out.println("      3. BlackBerry \n");
			System.out.println("      4. Exit \n");
			System.out.println("Enter your Choice : ");

			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				choice = Integer.parseInt(br.readLine());
			}catch(Exception e){
				System.out.println(e);
			}

			ShopKeeper sk = new ShopKeeper();

			switch (choice) {
			case 1:{
				sk.iphoneSale();
			}
				break;
			case 2 :{
				sk.samsungSale();
			}
				break;
			case 3 :{
				sk.blackBerrySale();
			}
				break;
			default:{
				System.out.println("You have purchased nothing.");
			}
			return;
			}
		}while(choice !=4);

	}

}
