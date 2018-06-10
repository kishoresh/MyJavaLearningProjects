package com.exercises.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

/*
Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. 
Try to solve this problem using Arraylist.

You are given  lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in  position of  line. 
Take your input from System.in.
Input Format
The first line has an integer . In each of the next  lines there will be an integer  denoting number of integers on that line and then there will be  space-separated integers. 
In the next line there will be an integer  denoting number of queries. Each query will consist of two integers x and y.

Constraints
Each number will fit in signed integer.
Total number of integers in  lines will not cross .

Output Format
In each line, output the number located in  position of  line. If there is no such position, just print "ERROR!"

Sample Input :
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
Sample Output :
74
52
37
ERROR!
ERROR!
 */
public class QueryArrayList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//Store the list of Numbers in the mainList 
		ArrayList[] mainList = new ArrayList[n];
		sc.nextLine();
		for (int i=0; i<n; i++){
			int m = sc.nextInt();
			mainList[i] = new ArrayList<Integer>();
			for(int j=0; j<m; j++){
				mainList[i].add(sc.nextInt());
			}	
		}
		
		sc.nextLine();
		int q=sc.nextInt();
		//Store the list of query numbers in the queryList 
		ArrayList[] queryList = new ArrayList[q];
		for(int i=0; i<q; i++){
			//int m = sc.nextInt();
			queryList[i] = new ArrayList<Integer>();
			for(int j=0; j<2; j++){
				queryList[i].add(sc.nextInt());
			}	
		}

		for (int i=0; i < n; i++){
			System.out.println( mainList[i].toString());
		}
		for (int i=0; i < q; i++){
			System.out.println( queryList[i].toString());
		}

		for (int i=0; i < q; i++){	
			int k = (Integer) queryList[i].get(0);
			int l = (Integer) queryList[i].get(1);
			if (mainList[k-1].size() < l){
				System.out.println("ERROR!");
			}else
			   System.out.println(mainList[k-1].get(l-1));
		}
	}

}
