package com.collections.stack;

import java.util.Stack;
/*
 * This is a special exercise to find the Min from a Stack.
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() 
 * and an additional operation getMin() which should return minimum element from the SpecialStack. 
 * All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard Stack data structure
 * and no other data structure like arrays, list, .. etc
 * http://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 */

public class SpecialStack extends Stack<Integer> {
	Stack<Integer> min = new Stack<Integer>();
	
	void push(int x){
		if (isEmpty()){			
			super.push(x);
			min.push(x);
		}
		else{
			super.push(x);
			int y = min.pop();
			min.push(y);
			if (x > y){
				min.push(y);
			}else
				min.push(x);
		}		
	}
	
	public Integer pop(){
		int x = super.pop();
		min.pop();
		return x;
	}
	
	 int getMin(){
	   int y = min.pop();
	   min.push(y);
	   return y;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpecialStack st = new SpecialStack();
		st.push(29);
		st.push(14);
		st.push(23);
		st.push(28);
		System.out.println(st.getMin());
		
	}

}
