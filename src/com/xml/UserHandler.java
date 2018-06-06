package com.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {
	boolean bFirstName = false;
	boolean bLastName = false;
	boolean bMarks = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("student")){
			String rollNo = attributes.getValue("rollno");
			System.out.println("Student Roll No : " + rollNo);
		}
		else if (qName.equalsIgnoreCase("firstname")){
			bFirstName = true;
		}
		else if (qName.equalsIgnoreCase("lastname")){
			bLastName = true;
		}
		else if (qName.equalsIgnoreCase("marks")){
			bMarks = true;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("student")){
			System.out.println("End Elelment : " + qName);
		}
	}
	
	@Override                      //Called when a character data is encountered.
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (bFirstName){
			System.out.println("First Name : " + new String(ch, start, length));
			bFirstName = false;
		}
		else if (bLastName){
			System.out.println("Last Name : " + new String(ch, start, length));
			bLastName = false;
		}
		else if (bMarks) {
			System.out.println("Marks : " + new String(ch, start, length));
			bMarks = false;
		}
	}

}
