package com.exercises.hackerrank;
/*
 * Given a list of sweet name (voted by all the employees) we need to select which is the most voted one.
 * If there is more than one sweet having the max no of votes, the first one sorted lexically should be displayed.  
 */
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class WhichSweettoTake {
	
	static String whichSweetShouldIBring(String[] votes) {	     
		//TreeSet<String> tree = new TreeSet<>();
		Map<String, Integer> hm = new TreeMap();   //Using TreeMap, becz elements are sorted.
	        for(String s:votes){
	        	if (hm.containsKey(s)){
	        		hm.put(s, hm.get(s) + 1);
	        	}else
	        		hm.put(s, 1);
	        }
	       
	       int max = 0; 
	       String s = "";
	       for(Map.Entry<String, Integer> e : hm.entrySet()){	    	   
	    	   int m = Math.max(max, e.getValue()); 
	    	   System.out.println(e.getKey() + "=" + e.getValue()); // + " m=" + m);
	    	   if (m > max){
	    	       s = e.getKey();
	    	   }
	    	   max = m;
	       }       	       
	        return s;
	    }
	
	public static void main(String[] args) {
		//String[] arr = {"Barfi","Gulab Jamun","Bundi Laddu", "Perra", "Rasgulla", "Gazar Halwa", "Gulab Jamun", "Gulab Jamun", "Gazar Halwa", "Laddu", "Gazar Halwa"};
		String[] arr = {"bat", "cat", "dog", "rat", "dog", "bat", "cat", "dog", "cat", "rat", "cat", "dog"};
		String str = whichSweetShouldIBring(arr);
        System.out.println(str);
	}

}
