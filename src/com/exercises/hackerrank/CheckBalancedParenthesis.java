package com.exercises.hackerrank;
/*
 * Take a series of parenthesis as input and then check if it is balanced.
 * URL : https://www.youtube.com/watch?v=akVVgmVb01I
 */

import java.util.Scanner;
import java.util.Stack;

public class CheckBalancedParenthesis {

	/*
	 * Return TRUE if :
	 * 1. str is empty.
	 * 2. There is a balanced parenthesis.
	 */
	public static boolean isBalancedParenthesis(String str){
		String OPEN ="{[(", CLOSE = "}])";
		Stack<Character> stack = new Stack<>();
		for(int i=0; i < str.length(); i++){
			Character ch = str.charAt(i);
			if (OPEN.indexOf(ch) >= 0)
				stack.push(ch);
			if (CLOSE.indexOf(ch) >=0){
				if (stack.size() > 0){     //there is a open bracket in the stack.
					if (!isParenthesisMatching(stack.pop(), ch)){
						return false;
					}
				}else                     //there is no open bracket in the stack, and we found a close bracket.
					return false;
			}			
		}
		if (stack.size() > 0 )   //This has to be checked, for this case '{}(' - Here '(' will stay in the stack as there is no corresponding close bracket.
			return false;
		return true;
	}
	
	//Is the parenthesis matching i.e. is it balanced and is ch2 opposite of ch1. Note ch1=Closing bracket and ch2= Open bracket
	public static boolean isParenthesisMatching(char ch1, char ch2){
		if (ch1 == '{' && ch2 == '}'){
			return true;
		}
		if (ch1 == '[' && ch2 == ']'){
			return true;
		}
		if (ch1 == '('  && ch2 == ')'){
			return true;
		}
		return false;		
	}
	
	public static boolean isBalanced(String str){
		String OPEN = "{([", CLOSE="})]";
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<str.length(); i++){
			Character ch = str.charAt(i);
			if (OPEN.indexOf(ch) > 0)
				stack.push(ch);
			else if (CLOSE.indexOf(ch) > 0){
				if (!isParenthesisMatching(ch, stack.pop()))
					return false;				
			}
			 if (stack.size() > 0)
				 return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string of parenthesis : ");
		String str = sc.next();
		System.out.println(isBalancedParenthesis(str));
	}

}
