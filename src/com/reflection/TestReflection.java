package com.reflection;
/*
 * Note : Test method invoker using Reflection.
 * 1. Load the class at runtime with Class.forName()
 * 2. Point to the method with cls.getDeclaredMethod()
 * 3. Invoke the method with method.invoke()
 */
import java.lang.reflect.Method;
import java.sql.Connection;
import com.jdbc.connection.TestJDBC;

public class TestReflection {

	public static void main(String[] args) {
		Class noParams[] = {};
		
		Class strParams[] = new Class[1];
		strParams[0] = String.class;

		try{
			// Load the class at runtime.
			Class cls = Class.forName("com.reflection.Simple");
			System.out.println("Name : " + cls.getName());
			Object obj =  cls.newInstance();
			
			//Call the method having no args.
			Method method = cls.getDeclaredMethod("showMsg", noParams);
			method.invoke(obj, null);
			
			//Call the method having a string argument
			method = cls.getDeclaredMethod("printString", strParams);
			method.invoke(obj, " Test string ");
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
