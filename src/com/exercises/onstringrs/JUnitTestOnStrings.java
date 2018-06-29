package com.exercises.onstringrs;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mysql.jdbc.AssertionFailedException;

public class JUnitTestOnStrings {

	@Test
	public void testToggleWord() {
		TestOnString testOnString = new TestOnString();
		String retString = testOnString.ToggleEachWordInAString();
		assertEquals(" iNDIA iS  oNE oF tHE   gREATEST  cOUNTRY ", retString);
	}

}
