package com.exercises.prime;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

public class PrimeNumber {

	//Generate and print all the prime numbers upto the max number specified.
	public void GeneratePrimeNumbers(int max){
		System.out.println("Generating Prime numbers between 1 and "+max);

		for(int i=1; i < max; i++){
			boolean isPrimeNo = true;

			for (int j=2; j < i; j++){
				if (i % j == 0){
					isPrimeNo = false;
					break;
				}
			}
			if (isPrimeNo) {
				System.out.print(i + " ");
			}
		}
	}

	public boolean CheckIfPrimeNumber(int number){
		int n = number/2;  //11
		boolean isPrimeNo = true;

		for (int i=2; i < n; i++){     //2 < 11
			if (number % i == 0){      //if no remainder
				isPrimeNo = false;
				break;
			}
		}
		return isPrimeNo;
	}

	public static void main(String[] args) {
		int max = 200;
		PrimeNumber pm = new PrimeNumber();
		pm.GeneratePrimeNumbers(max);

		int primeNo = 23;
		boolean isPrime = pm.CheckIfPrimeNumber(primeNo);
		if (isPrime)
			System.out.println("\nNo "+ primeNo+" is prime nummber.");
	}

}
