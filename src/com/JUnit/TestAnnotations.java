package com.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runners.JUnit4;

public class TestAnnotations {

	@Test
	public void test() {
		//test data
		String str1 = new String("abc");
		String str2 = new String("abcd");
		String str3 = null;
		String str4 = "abc";
		String str5 = "abc";
		int val1 = 5;
		int val2 = 6;
		
		assertEquals(str1, str2);
		
	}
	
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(TestAnnotations.class);
	}

}
