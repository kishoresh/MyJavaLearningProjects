package com.collections.hashcode;
/*
 * Testing the Usage of hashCode() & equals() method.
 * 1. Storing String as the key in the HashMap. This does not require to override equals() & hashCode().
 *    String is best to maintain uniqueness, because it is immutable, and duplicate string will have the same hashcode() or memory address.
 * 
 * 2. Storing Student obj as the key in the HashMap. If we need to maintain some uniqueness, say Student Registration ID, 
 *    this will require to override equals() & hashCode().
 *    
 * Note : We can also comment the overriden method hashCode(). In that case hashcode will be diff for all objects.    
 */
import java.util.HashMap;

import com.collections.hashcode.*;
import com.sun.javafx.collections.MappingChange.Map;

public class HashCodeDemo {
	
	private static HashMap<String, ReportCard> hm1 = new HashMap<String, ReportCard>();	
	private static HashMap<Student, ReportCard> hm2 = new HashMap<Student, ReportCard>();
	
	//1. Here the unique key identifier is a string in the Hashmap. So we no need to override the equals() or hashcode() method. 
	public static void populateDataIntoHashMap1(){
		ReportCard r1 = new ReportCard(88.5, 67.6, 78.3);
		ReportCard r2 = new ReportCard(82.5, 63.6, 72.3);
		ReportCard r3 = new ReportCard(84.5, 62.6, 71.3);

		System.out.println("1. HashMap Demo without the use of overriding Equals() & hashCode()");
		
		hm1.put("Kishore", r1);
		hm1.put("Balaji", r2);
		hm1.put("Usha", r3);
		hm1.put("Kishore", r3);  //This entry will be ignored, as HashMap stores unique key identifiers.   
	}
	
	//2. Here the unique key identifier is an Object in the HashMap. 
	//So in order to maintain the uniqueness of the Student obj within the HashMap key we need to override its Equals() & hashcode() method.
	//Here observe that the RegID is duplicate.
	public static void populateDataIntoHashMap2(){
		Student s1 = new Student(101, "Kishore", 43);		
	    Student s2 = new Student(101, "Balaji", 34); //This will be ignored, for duplicate RegID, if we override the Equals() & Hashcode().
		Student s3 = new Student(103, "Usha", 41);
		Student s4 = new Student(103, "Usha", 41);
		
		ReportCard r1 = new ReportCard(88.5, 67.6, 78.3);
		ReportCard r2 = new ReportCard(82.5, 63.6, 72.3);
		ReportCard r3 = new ReportCard(84.5, 62.6, 71.3);

		System.out.println("2. HashMap Demo with the use of overriding Equals() & hashCode()");
		
		hm2.put(s1, r1);
		hm2.put(s2, r2);
		hm2.put(s3, r3);
		hm2.put(s4, r3);
	}

	public static void main(String[] args){
		populateDataIntoHashMap1();
		System.out.println("Size = " + hm1.size());		

	    // Check the output of hm2.size() by commenting/uncommenting the overriden Equals() & hashCode()		
		populateDataIntoHashMap2();
		System.out.println("Size = " + hm2.size()); 				
	}

}
