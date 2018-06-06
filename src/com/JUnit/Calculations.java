package com.JUnit;

public class Calculations {
	
	public static int findMax(int arr[]){
		int max=0;
		for(int i=0; i < arr.length; i++){
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	
	public static int cube(int i){
		return (i*i*i);
	}
	
	public static String reverse(String str){
		StringBuilder reverseStr = new StringBuilder(str);
		return reverseStr.reverse().toString();
	}

}
