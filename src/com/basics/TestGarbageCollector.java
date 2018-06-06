package com.basics;
/*
 * Garbage collection demo.
 * 
 */
public class TestGarbageCollector {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Garbage Collected");
		super.finalize();
	}
	
	public static void main(String[] args) {
		TestGarbageCollector testgc1 = new TestGarbageCollector();
		TestGarbageCollector testgc2 = new TestGarbageCollector();
		
		testgc1 = null;
		testgc2 = null;
		System.gc();
	}

}
