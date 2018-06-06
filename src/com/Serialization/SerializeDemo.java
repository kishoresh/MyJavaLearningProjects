package com.Serialization;
/*
 * Assign values to the Employee obj and save into file using serialization.
 * Using class FileOutputStream and ObjectOutputStream.
 * URL : http://www.tutorialspoint.com/java/java_serialization.htm
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {

	public static void main(String[] args) {
		Employee emp= new Employee();
		emp.name = "Kishore";
		emp.address = "Pimple Saudagar";
		emp.SSN = 123;
		emp.empid = 101;

		try{
			String filePath = "D:/employee2.ser";
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(emp);
			objOut.close();
			fileOut.close();
			System.out.println("Object output is saved in %s " + filePath);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
