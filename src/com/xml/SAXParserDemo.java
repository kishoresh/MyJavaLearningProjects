package com.xml;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserDemo {

	public static void main(String[] args) {
		try{
			File inputFile = new File("D:/My Folder/MyJavaProjects/src/com/xml/Students.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser SAXparser = factory.newSAXParser();  //Instantiate a SAXParser obj from the factory.
			UserHandler userhandle = new UserHandler();    //Instantiate the Event handler
			SAXparser.parse(inputFile, userhandle);		  //Pass the Event handler as a parameter to the SAXParser obj.	
		}catch (Exception e){
			e.printStackTrace();
		}	

	}

}
