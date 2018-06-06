package com.xml.jaxb.marshalling;
/*
 * 1. Convert the Employee object to an XML using JAXB Marshaller.
 * 2. Convert the Question object to an XML using JAXB Marshaller.
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ObjectToXML {
	
	//1. Convert the Employee object to an XML.
	public static void ConvertEmployeeObjectToXML(){
		try{
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Employee emp = new Employee(1, "Kishore Sharma", 50000);
			marshaller.marshal(emp, new FileOutputStream("com/xml/jaxb/Employee.xml"));

		}catch (JAXBException|FileNotFoundException e){
			e.printStackTrace();
		}finally{
			System.out.println("XML file Employee.xml is generated with employee information.");
		}	
	}
	
	//2. Convert the Question object to an XML
	public static void ConvertQuestionObjectToXML(){
		try{
			JAXBContext context = JAXBContext.newInstance(Question.class);
			Marshaller marshaller = context.createMarshaller();
			
			Answer ans1 = new Answer(1, "Java is a programming language.", "Kishore Sharma");
			Answer ans2 = new Answer(2, "Java is a platform.", "Ravikant Chauhan");
			ArrayList<Answer> ansList = new ArrayList<>();
			ansList.add(ans1);
			ansList.add(ans2);
			Question qs = new Question(1, "What is Java ?", ansList);

			marshaller.marshal(qs, new FileOutputStream("com/xml/jaxb/Question.xml"));
		
		}catch (JAXBException|FileNotFoundException e){
			e.printStackTrace();
		}finally{
			System.out.println("XML file Question.xml is generated with employee information.");
		}
		
	}
	
	public static void main(String[] args) {
		//ConvertEmployeeObjectToXML();
		ConvertQuestionObjectToXML();
	}

}
