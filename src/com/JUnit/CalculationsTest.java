package com.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculationsTest {


	@Test
	public void testfindMax() {
		assertEquals(63, Calculations.findMax(new int[]{3,12,45,32,13,43,63}));
		assertEquals(45, Calculations.findMax(new int[]{23,12,45,32,13,43}));
		assertEquals(10, Calculations.findMax(new int[]{2,3,4,5,6,7,8,9,10}));
	}
	
	@Test
	public void tesCube() {		
		assertEquals(27, Calculations.cube(3));
	}
	
	@Test
	public void testReverseString(){
		String str = "  India is  one of the   greatest  Country  ";
		String reverseStr = "  yrtnuoC  tsetaerg   eht fo eno  si aidnI  ";
		assertEquals(reverseStr, Calculations.reverse(str));
	 }
}
