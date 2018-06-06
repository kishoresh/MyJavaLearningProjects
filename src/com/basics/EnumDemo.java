package com.basics;
/*
 * Enum with fields and methods.
 * Constructor Direction(shortcode) is called when we initialize an enum.
 * Later when the getter method is called we get the corresponding shortcode.
 */
enum Directions{
	EAST ("E"),
	WEST ("W"),
	SOUTH ("S"),
	NORTH ("N")
	;        // must have a semicolon at the end, before fields or method starts.
	
	 private final String shortcode;
	 private Directions(String code) {     //Constructor
		this.shortcode = code;
	}
	
	 String getDirectionShortCode(){   //Getter method of the shortcode.
		 return this.shortcode;
	 }
}

public class EnumDemo {

	public static void main(String[] args) {
		Directions dir = Directions.EAST;     //This calls the constructor as Directions("E")
		System.out.println(dir.getDirectionShortCode());
		Directions dir2 = Directions.SOUTH;   //This calls the constructor as Directions("S")
		System.out.println(dir2.getDirectionShortCode());
		
		//Few small test to see data conversion.
		long num = 1234567891;
		int i = (int)num;
		System.out.println(i);
		double num2 = 1234.45;
		int j = (int)num2;
		System.out.println(j);
		
		Integer e = new Integer(100);
		Integer f = new Integer(100);
		System.out.println(e == f);
		System.out.println(e.equals(f));
		
	}

}
