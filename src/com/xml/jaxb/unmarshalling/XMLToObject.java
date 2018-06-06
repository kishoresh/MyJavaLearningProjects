package com.xml.jaxb.unmarshalling;
/*
 * 1. Convert the Employee.xml file into an Employee object using JAXB UnMarshaller.
 * 2. Convert the Question.xml file into an Question object using JAXB UnMarshaller.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;

import com.xml.jaxb.marshalling.Answer;
import com.xml.jaxb.marshalling.Employee;
import com.xml.jaxb.marshalling.Question;

public class XMLToObject {
	//1. Convert the Employee.xml file into an Employee object
	public static void ConvertEmployeeXMLToObject(){
		try{
			File fl = new File("com/xml/jaxb/Employee.xml");
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Employee emp = (Employee) unmarshaller.unmarshal(fl);
			System.out.println("Employee Details : " + "\nID : "+emp.getId() + "\nName : " + emp.getName()+ "\nSalary : " + emp.getSalary());
		}catch (JAXBException e){
			e.printStackTrace();
		}	
	}
	
	//2. Convert the Question.xml file into an Question object
	public static void ConvertQuestionXMLToObject(){
		try{
			File fl = new File("com/xml/jaxb/Question.xml");
			JAXBContext context = JAXBContext.newInstance(Question.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Question qs = (Question) unmarshaller.unmarshal(fl);
			System.out.println("Question Details : " + "\nID : "+qs.getId() + "\nQuestion : " + qs.getQuestionname());
			System.out.println("\nAnswers : ");
			for(Answer ans:qs.getAnswers()){
				System.out.println(ans.getId() + " " + ans.getAnswername() + " " + ans.getPostedBy());
			}
			
		}catch (JAXBException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//ConvertEmployeeXMLToObject();
		ConvertQuestionXMLToObject();
		
	}

}
