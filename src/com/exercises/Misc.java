package com.exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

/*
 * Miscellaneous excercises :
 * 1. Integer Cache mechanism
 * 2. Check Two Strings Are Anagrams or Not
 * 3. tOOGLE each word in a string.
 * 4. Check if a string is Palindrome (using StringBuilder)
 * 5. Check if a string is Palindrome without using StringBuilder
 * 6. Strings can be used in switch case statement, in Java 7
 * 7. Find all the permutations of a string. 
 * 8. Insert a character in the position specified in the string.
 * 9. Test Regular Expressions.
 */
public class Misc {
	//Guess the output of the following ? 
	//1. Due to Java Integer cache mechanism, Integer value ranging from -127 to 127 are cached and only in case of autoboxing.
	public static void CheckJavaIntegerCaching(){
		Integer a=1000, b=1000;
		System.out.println(a == b);
		
		Integer c=100, d=100;
		System.out.println(c == d);
		
		Integer e = new Integer(100);
		Integer f = new Integer(100);
		System.out.println(e == f);
	}
	
	//2. To check whether two strings are anagram or not? 
	public static void CheckTwoStringsAreAnagrams(){
		String s1 = "Mother In Law";   //"home";
		String s2 = "Hitler Woman";    //"mohe";
		
		s1 = s1.replaceAll("\\s", "").toLowerCase();
		s2 = s2.replaceAll("\\s", "").toLowerCase();
		
		char[] chrarr1 = s1.toCharArray();
		char[] chrarr2 = s2.toCharArray();
		
		Arrays.sort(chrarr1);
		Arrays.sort(chrarr2);
		boolean result = Arrays.equals(chrarr1, chrarr2);
//		boolean result = new String(chrarr1)                //This also works
//                .equals(new String(chrarr2));
		
		System.out.println(result);		
	}
	
	//3. tOOGLE each word in a string.
	public static void tOGGLEEachWordOfAString(){
		String str = "My name is Kishore";
		System.out.println(str);
		
		String[] words = str.split("\\s");
		String toggle="";
		
		for(String w:words){
			String first = w.substring(0, 1);
			String afterFirst = w.substring(1);
			
			toggle += first.toLowerCase() + afterFirst.toUpperCase() + " ";			
		}
		System.out.println(toggle);		
	}
	
	//4. Check if a string is Palindrome (using StringBuilder)
	public static void CheckPalindromeString(){
		String str = "nitin";
		
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		
		if (str.equals(sb.toString())){
			System.out.println("String is Palindrome.");
		}else{
			System.out.println("String is not Palindrome.");
		}			
	}
	
	//5. Check if a string is Palindrome without using StringBuilder
	public static Boolean isPalindromeString(String str){
		if (str == null){
			return false;
		}
		
		int len = str.length();
		for (int i=0; i < len/2; i++){
			if (str.charAt(i) != str.charAt(len - i -1)){
				return false;
			}
		}
		return true;
	}
	
	
	//6. Strings can be used in switch case statement, in Java 7
	public static void PrintColoursUsingSwitchCase(String color){
		switch(color){
		case "red":
			System.out.println("Red color");
			break;
		case "blue" :
			System.out.println("Blue color");
			break;
		case "black" :
			System.out.println("Black color");
			break;
		default :
			System.err.println("Default color");
		}
	}
	
	//7. Find all the permutations of a string. 
	public static Set<String> PermutaionFinder(String str){
		Set<String> perm = new LinkedHashSet<>();
		if (str == null){
			return null;
		}else if (str.length() == 0){
			perm.add("");
			return perm;
		}
		
		char initialChar = str.charAt(0);
		String rem = str.substring(1);		
		Set<String> words = PermutaionFinder(rem);
		for(String word:words){
			for(int i = 0; i <= word.length(); i++){
				//Merge D with [""]                              -> perm (recur1) = [D]
				//Merge C with [D]                               -> perm (recur2) = [CD, DC]
				//Merge B with [CD], DC]                         -> perm (recur3) = [BCD, CBD, CDB,   BDC, DBC, DCB]				
				//Merge A with [BCD, CBD, CDB,   BDC, DBC, DCB]  -> perm (recur4) = [ABCD, BACD, BCAD, BCDA,    ACBD, CABD, CBAD, CBDA,    ACDB, CADB, CDAB, CDBA,    ABDC, BADC, BDAC, BDCA,     ADBC, DABC, DBAC, DBCA,    ADCB, DACB, DCAB, DCBA]
				perm.add(characterInsert(word, initialChar, i));	
			}			
		}		
		return perm;		
	}	
	
	//8. Insert a character in the position specified in the string.
	public static String characterInsert(String s, char c, int j){
		String beginStr = s.substring(0,j);
		String endStr = s.substring(j);
		return beginStr + c + endStr;
	}
	
	//9. Test Regular Expressions.
	public static void TestRegularExpression(){
        System.out.println(Pattern.matches("[amn]", "abc"));   //False
        System.out.println(Pattern.matches("[amn]", "a"));     //True
        System.out.println(Pattern.matches("[amn]", "amn"));   //False
        
        System.out.println(Pattern.matches("[amn]?", "mdsf"));  //False :a or m or n must come for one time
        System.out.println(Pattern.matches("[amn]?", "a"));     //True  :a or m or n must come for one time
        
        System.out.println(Pattern.matches("[amn]+", "amnamn"));      //True : a or m or n can come more than once.
        System.out.println(Pattern.matches("[amn]+", "aaammmnnnn"));  //True
        System.out.println(Pattern.matches("[amn]+", "aabamnn"));  //True
        
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "abc123"));  //True
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "abcAS123"));//False : More than 6 
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JAZ123"));  //True
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "abc12$"));  //False : $ is not matched.
        
        System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9953038949"));//true  
        System.out.println(Pattern.matches("[789][0-9]{9}", "9953038949"));//true  
          
        System.out.println(Pattern.matches("[789][0-9]{9}", "99530389490"));//false (11 characters)  
        System.out.println(Pattern.matches("[789][0-9]{9}", "6953038949"));//false (starts from 6)  
        System.out.println(Pattern.matches("[789][0-9]{9}", "8853038949"));//true  	
	}
	
	//10. Test Compilation error - Unreachable catch block for ArithmeticException. it is already handled by catch block Exception
	public static void TestCompilationError(){
		int x = 10;
		int y = 20;
		try{
			for (int z = 2; z >= 0; z--){
				int ans = x / z;
				System.out.println(ans + " ");
			}
		}catch (Exception e){
			System.out.println("E1" + e.getMessage());
//		}catch (ArithmeticException e){            //Compilation error
//			System.out.println("E2");
		}
	}

	
    public static void main(String[] args) {
		//CheckJavaIntegerCaching();
		//CheckTwoStringsAreAnagrams();
		//tOGGLEEachWordOfAString();
		//CheckPalindromeString();
		//PrintColoursUsingSwitchCase("red");
		//PrintColoursUsingSwitchCase("blue");
		
		//Check if a string is Palindrome without using StringBuilder
		String str = "nitin";
		if (isPalindromeString(str)){
			System.out.println(str + " - String is a Palindrome");
		}else
			System.out.println(str + " - String is not a Palindrome");
		
		//Permatution finder
		String s = "AAC";
        String s1 = "ABC";
        String s2 = "ABCD";
        System.out.println("\nPermutations for " + s + " are: \n" + PermutaionFinder(s));
        System.out.println("\nPermutations for " + s1 + " are: \n" + PermutaionFinder(s1));
        System.out.println("\nPermutations for " + s2 + " are: \n" + PermutaionFinder(s2));
		
        //Regular Expression Examples
        TestRegularExpression();
        TestCompilationError();
	}

}
