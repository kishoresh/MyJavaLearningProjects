package com.exercises.onstringrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.camel.impl.StringDataFormat;

/*
 * Exercises on String :
 * 1. Count the number of words in a String.
 * 2. Remove all the white spaces in a string.
 * 3. Toggle each word in a string. i.e toggle = tOGGLE
 * 4. Capitalize each word in a string.
 * 5. Reverse a string by Reverse iteration using substring
 * 6. Reverse a string using StringBuilder/StringBuffer
 * 7. Reverse a string by Reverse iteration using char array.
 * 8. Reverse each word in a string 
 * 9. Check how to optimize string creation with String Literal.
 * 10. Swap Two String Variables without temp variable.
 * 11. Remove all white spaces
 * 12. Formatting strings and numbers
 * 13. Check that there is qqual pair of curly braces.
 * 
 */
public class TestOnString {
	public static String str = "  India is  one of the   greatest  Country  ";
	
	//1. Count the number of words in a String
	public static void CountTheNumberOfWordsInAString(){
		
	}

	//2. Remove all the white spaces in a string.
	public static void RemoveWhiteSpaces(){
		
	}
	
	//3. Toggle each word in a string. i.e toggle = tOGGLE 
	public static void ToggleEachWordInAString(){
		String words[] = str.split("\\s");
		String toggle = "";
		
		for(String w:words){
			String firstChar = "";
			String afterFirst = "";
			if (w.length() > 1){
				firstChar = w.substring(0, 1);
				afterFirst = w.substring(1);
			}
			toggle += firstChar.toLowerCase() + afterFirst.toUpperCase() + " ";
		}
		System.out.println("Toggle each word in a string " + toggle);
	}
	
	//4. Capitalize each word in a string.
	public static void CapitalizeEachWordInAString(){
		String words[] = str.split("\\s");
		String CapitalizeWord = "";
		for(String w:words){
			String first = "";
			String afterFirst = "";
			if (w.length() > 1){         //This is required as there are spaces in between, to avoid IndexOutOfBound error
				first = w.substring(0, 1);
				afterFirst = w.substring(1);
			}
			CapitalizeWord+= first.toUpperCase() + afterFirst+" ";
		}
		System.out.println("Capitalize each word in a string = " + CapitalizeWord);
	}
	
	//5. Reverse a string by Reverse iteration using substring
	public static void ReverseString1(){
		String ReverseStr = "";
		for(int i = str.length()-1; i>0 ; i--){
			ReverseStr+= str.substring(i-1, i);
		}
		System.out.println("Reverse string using Substring     = " + ReverseStr);
	}
	
	//6. Reverse a string using StringBuilder/StringBuffer
	public static void ReverseString2(){
		StringBuilder ReverseStr = new StringBuilder(str);
		System.out.println("Reverse string using StringBuilder = " + ReverseStr.reverse());
	}
	
	//7. Reverse a string by Reverse iteration using char array.
	public static void ReverseString3(){
		char ch[] = str.toCharArray();
		String ReverseStr = "";
		for(int i=ch.length-1; i > 0; i--){
			ReverseStr += ch[i];	
		}
		System.out.println("Reverse string using char array  = " + ReverseStr);
	}
	
	//8. Reverse each word in a string 
	public static void ReverseEachWordInString3(){
		String words[] = str.split("\\s");
		String ReverseStr = "";
		for(String w:words){
			StringBuilder s = new StringBuilder(w);
			ReverseStr += s.reverse() + " ";
		}
		System.out.println("Reverse each word in a string    = " + ReverseStr);
	}
	
	//9. Q : Check how to optimize string creation ?
	//Ans : By using string literal. Diff is visible when we create many strings.
	public static void CheckStringCreationPerformance(){
		long startTime = System.currentTimeMillis();
		for (int i=0; i < 1000000000; i++){
			String str1 = "India";
			String str2 = "India";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to create string using String Literal is = " + (endTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		for (int i=0; i < 1000000000; i++){
			String str1 = new String("India");
			String str2 = new String("India");
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time taken to create Object String is = " + (endTime - startTime) + " ms");		
	}
	
	//10. Swap Two String Variables without temp variable.
	public static void SwapTwoStringVariables(){
		String str1 = "Love";
		String str2 = "You";
		str1 = str1 + str2;
		str2 = str1.substring(0, str1.length() - str2.length());
		str1 = str1.substring(str2.length());
		
		System.out.println("Swapeed string : str1 = "+str1);
		System.out.println("Swapeed string : str2 = "+str2);
	}
	
	//11. Remove all white spaces
	public static void RemoveAllWhiteSpaces(){
		//1st Way
		String s = str.replaceAll("\\s", "");
		
		//2nd Way
		char[] strArray = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < strArray.length; i++){
			if ((strArray[i] != ' ') && (strArray[i] != '\t')){
				sb = sb.append(strArray[i]);
			}
		}
			
		System.out.println("String with Removed white spacess = " + s);
		System.out.println("String with Removed white spacess = " + sb);
		
	}
	
	//12. Formatting strings and numbers
	public static void TestFormatStrings(){
		String output = String.format("%s=%d", "Kishore", 35);		//Kishore=35
		//output = String.format("|%30s|", "Hello World");         //|                   Hello World| 
		//output = String.format("|%-30s|", "Hello World"); 		    //|Hello World                   |    Left justify
		//output = String.format("|%30.5s|", "Hello World");		//|                         Hello|          Field width and max chars
		//output = String.format("|%(d|", -35);		//|(35)|
		//output = String.format("|%,d|", 1000000);   //|1,000,000|
		output = String.format("|%+d|", -93);         //|-93|
		System.out.println(output);
	}
	
	//13. Check that there is equal pair of curly braces.
	public static void CheckForEqualPairOfCurlyBraces(){
		String input = "{{{{}}}}{{}}}}}}";   //"{{}{{{}{}}";
		char ch[] = input.toCharArray();
		if (ch.length % 2 > 0){
			System.out.println("Not even numbers of braces.");
		}else{
			char[] chr1 = new char[ch.length/2];
			char[] chr2 = new char[ch.length/2];
			int j=0,k=0;			
			for(int i=0; i < ch.length/2 ; i++){
				if (ch[i] == '{'){       
					chr1[j] = ch[i];
					j++;
				}
				else if (ch[i] == '}'){
					chr2[k] = ch[i];
					k++;
				}else{
					System.out.println("Some different character other than { or }.");
				}
			}
			String str1 = chr1.toString();
			String str2 = chr2.toString();
			if (str1.length() == str2.length()){
				System.out.println("Matching pairs.");
			}else
				System.out.println("Not Matching pairs.");
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(str);
		CapitalizeEachWordInAString();
		ToggleEachWordInAString();
		
		//Reverse String
		ReverseString1();
		ReverseString2();
		ReverseString3();
		
		ReverseEachWordInString3();
		
		CheckStringCreationPerformance();
		
		SwapTwoStringVariables();
		
		RemoveAllWhiteSpaces();
		TestFormatStrings();
		CheckForEqualPairOfCurlyBraces();
		
		try{
			String dt = "21/01/1973";
			System.out.println(new SimpleDateFormat("dd/mm/yyyy").parse(dt));
		}catch (ParseException e){
			e.printStackTrace();
		}
	}

}
