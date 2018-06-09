package com.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Given a list, , of  integers, perform  queries on the list. Once all queries are completed, print the modified list as a single line of space-separated integers.

Input Format
The first line contains an integer,  (the initial number of elements in ). 
The second line contains  space-separated integers describing . 
The third line contains an integer,  (the number of queries). 
The  subsequent lines describe the queries, and each query is described over two lines:

If the first line of a query contains the String Insert, then the second line contains two space separated integers , and the value  must be inserted into  at index .
If the first line of a query contains the String Delete, then the second line contains index , whose element must be deleted from .
Constraints

Each element in is a 32-bit integer.
Output Format

Print the updated list  as a single line of space-separated integers.

Sample Input
5
12 0 1 78 12
2
Insert
5 23
Delete
0

Sample Output
0 1 78 12 23
Explanation

 Insert 23 at index . 
 Delete the element at index 0. 
Having performed all  queries, we print  as a single line of space-separated integers.
Note : This works fine if the bound is fixed. If we try to insert in out of bound place we get error.
 */
public class ScannerTest {
	
	//Loop through from the back, and push back the element's one place backward, to make a space for the new element.
	public static int[] insert(int pos, int element, int[] arr){
		int[] ar = arr;
		
		for(int i=ar.length; i < pos; i--){
			ar[i] = ar[i-1];
		}
		ar[pos] = element;
		return ar;
	}
	
	//Create a new array of size 1 less than the original. Populate the elements till the position which needs to be deleted. After that position, copy the next element. 
	public static int[] delete(int pos, int[] arr){
		int[] ar = new int[arr.length - 1];	
		for(int i=0; i < pos; i++){
			ar[i] = arr[i];
		}
		for(int i=pos; i < arr.length - 1; i++){
			ar[i] = arr[i+1];
		}		
		return ar;
	}
	
	public static void testUsingArray(){
		int noOfElements = 0;
		int noOfQueries  = 0;

		Scanner sc = new Scanner(System.in);
		noOfElements = sc.nextInt();
		
		int[] intArr   = new int[noOfElements];
		
		for(int i=0; i<noOfElements; i++){
			intArr[i] = sc.nextInt();
		}		

		noOfQueries = sc.nextInt();		
		for(int i=0; i<noOfQueries; i++){			
			int idx;
			int newNo;
			
			String input = sc.next();
			idx = sc.nextInt();
			if (idx > intArr.length || idx <= 0){
				continue;
			}
			if (input.equalsIgnoreCase("INSERT")){
				intArr = insert(idx, sc.nextInt(), intArr);
			}else if (input.equalsIgnoreCase("DELETE")){				
				intArr = delete(idx, intArr);
			}
		}
		
		sc.close();
		System.out.println("List of elements in the array are :");
		for(int i=0; i<intArr.length; i++){
			System.out.println(intArr[i]);		
		}	
	}
	
	public static void testUsingArrayList(){
		int noOfElements = 0;
		int noOfQueries  = 0;

		Scanner sc = new Scanner(System.in);
		noOfElements = sc.nextInt();
		
		List<Integer> intArrList   = new ArrayList<>();
		
		for(int i=0; i<noOfElements; i++){
			intArrList.add(sc.nextInt());
		}		

		noOfQueries = sc.nextInt();		
		for(int i=0; i<noOfQueries; i++){						
			String input = sc.next();
			int idx = sc.nextInt();

			if (input.equalsIgnoreCase("INSERT")){
				intArrList.add(idx, sc.nextInt());
			}else if (input.equalsIgnoreCase("DELETE")){				
				intArrList.remove(idx);
			}
		}
		
		sc.close();
		for(int i=0; i<intArrList.size(); i++){
			System.out.print(intArrList.get(i) + " ");		
		}	
		//System.out.println("List of elements in the array are :"+ intArrList.toString());
	}
	
	public static void main(String[] args) {
		//testUsingArray();
		testUsingArrayList();
	}
}
