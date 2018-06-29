package com.exercises.palindrome;

import java.util.Scanner;

/*
 * A palindrome number is a number that is same after reverse.
 * For example 545, 151, 34543, 343, 171, 48984 are the palindrome numbers.
 *
 */
public class TestPalindromeNummber {

	static void checkPalindrome(){
		int r, sum=0, temp;
		int n = 454;
		temp = n;

		while (n>0) {
			r = n % 10;                  // r = 4, 5, 4
			sum = (sum * 10) + r;        // sum = 0 + 4, 4*10 + 5, 45 * 10 + 4
			n = n / 10;					 // n = 45, 4, 0
		}

		if (sum == temp)
			System.out.println("Number is a Palindrome number.");
		else
			System.out.println("Number is not a Palindrome number.");
	
	}
	
	//2dn way to check if the no is Palindrome. Convert the number to string and then check.
	public static void checkPalindrome2(){
		//Scanner sc = new Scanner(System.in);
		//int n =  sc.nextInt(); ////454;
		String s = Integer.toString(3245423);
		System.out.println(s);
		Boolean isPalindrome = true;
		int midNo = s.length() / 2;
		for(int i=0, j= s.length()-1; i < midNo; i++, j--){
			if (s.charAt(i) != s.charAt(j))
				isPalindrome = false;
		}
		if (isPalindrome)
			System.out.println("Number is a Palindrome number.");
		else
			System.out.println("Number is not a Palindrome number.");
	}
	
	public static void main(String[] args) {
		//checkPalindrome();
		checkPalindrome2();
	}

}
