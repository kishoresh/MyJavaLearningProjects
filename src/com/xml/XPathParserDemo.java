package com.xml;
/*
 * XPath Parser : Use path expression to select a node or list of nodes from an XML
 * Below example uses lot of path expression to point directly to that particular node.
 * URL : 	https://www.tutorialspoint.com/java_xml/java_xpath_query_document.htm
 * Modified on : 25th Feb 2018
 */
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import jdk.internal.org.xml.sax.SAXException;

public class XPathParserDemo {

	public static void main(String[] args) {
		try{
			File inputFile = new File("D:/My Folder/MyJavaProjects/src/com/xml/Students.xml");
		    DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    Document doc = dBuilder.parse(inputFile);
		    doc.getDocumentElement().normalize();
		    
		    //String expressions = "/class/student[@rollno = '493']";    //Point to this node only
		    //String expressions = "/class/student[3]";                  //Point to the 3rd Student node
		    //String expressions = "/class/student[last()]";             //Point to the last Student node
		    String expressions = "/class/student[last()-1]";             //Point to the 2nd last Student node 
		    XPath xpath = XPathFactory.newInstance().newXPath();
		    NodeList nodelist = (NodeList) xpath.compile(expressions).evaluate(doc, XPathConstants.NODESET);
		    for(int i=0; i < nodelist.getLength(); i++){
		    	Node node = nodelist.item(i);
		    	//System.out.println("Current Element : " + node.getNodeName() + " = " + node.getTextContent());
		    	if (node.getNodeType() == Node.ELEMENT_NODE){
		    		Element el = (Element) node;
		    		System.out.println("Roll No : " + el.getAttribute("rollno"));
		    		System.out.println("First Name : " + el.getElementsByTagName("firstname").item(0).getTextContent());
		    		System.out.println("Last Name  : " + el.getElementsByTagName("lastname").item(0).getTextContent());
		    		System.out.println("Marks      : " + el.getElementsByTagName("marks").item(0).getTextContent());
		    	}		    	
		    }
		}catch(ParserConfigurationException|IOException|org.xml.sax.SAXException|XPathExpressionException e){
			e.printStackTrace();
		}
	}

}
