package com.exercises.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class TestAnagramStrings {
	
	static boolean isAnagram(String a, String b) {
        char[] str1 = a.toLowerCase().toCharArray();
        char[] str2 = b.toLowerCase().toCharArray();
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        
        return Arrays.equals(str1, str2);  
       
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		System.out.println(isAnagram(str1, str2));

	}

}
