package com.Serialization;
/*
 * Read the input file having the serialized Employee object using deserialization
 * Using class FileInputStream & ObjectInputStream
 * URL : http://www.tutorialspoint.com/java/java_serialization.htm
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {

	public static void main(String[] args) {
		Employee emp = null;
		String filePath = "D:/employee2.ser";
		try{
			FileInputStream fileInput = new FileInputStream(filePath);
			ObjectInputStream objIn = new ObjectInputStream(fileInput);
			emp = (Employee) objIn.readObject();
			objIn.close();
			fileInput.close();
		}catch(IOException i){
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c){
			c.printStackTrace();
			System.out.println("Employee class not found in "+filePath);
			return;
		}

		System.out.println("Deserialized Employee details...");
		System.out.println("Employee Name : "+emp.name);
		System.out.println("Employee Add : "+emp.address);
		System.out.println("Employee EmpID : "+emp.empid);
		System.out.println("Employee SSN : "+emp.SSN);   //Note the value is not serialized.

		emp.mailCheck();
	}

}
