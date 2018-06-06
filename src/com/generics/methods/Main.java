package com.generics.methods;

public class Main {
	
	public static Pair<String, Integer> pair1 = new Pair<String, Integer>("Pair 1", 101);
	public static Pair<String, Integer> pair2 = new Pair<String, Integer>("Pair 1", 102);
	
	public static <K, V> boolean comparePair(Pair<K, V> p1, Pair<K, V> p2){
		if (p1.getKey().equals(p2.getKey())){
			return true;
		}
		else{
		   return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bool = comparePair(pair1, pair2);
		System.out.println(bool);

	}

}
