package com.exercises.palindrome;
/*
 * A palindrome number is a number that is same after reverse.
 * For example 545, 151, 34543, 343, 171, 48984 are the palindrome numbers.
 *
 */
public class TestPalindromeNummber {

	public static void main(String[] args) {
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

}
