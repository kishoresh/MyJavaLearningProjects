package com.exercises.armstrong;

/*
 * Armstrong number is a number that is equal to the sum of cubes of its digits for example 0, 1, 153, 370, 371, 407 etc.
 * 153 = (1*1*1)+(5*5*5)+(3*3*3)
 * where:
 * (1*1*1)=1
 * (5*5*5)=125
 * (3*3*3)=27
 * So: 1+125+27=153
 */

public class TestArmStrongNumber {

	public static void main(String[] args) {
		int c=0,a,temp;
		int n=153;
		temp=n;
		while(n>0){
			a = n % 10;        //Remainder's = 3, 5, 1
			n = n / 10;        //Dividend's  = 15, 1, 0
			c = c + (a*a*a);
		}
		if (temp==c)
			System.out.print("No is ArmStrong Number.");
		else
			System.out.print("No is not an ArmStrong Number.");

	}

}
