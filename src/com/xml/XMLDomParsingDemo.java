package com.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sun.security.util.Length;
/*
 * DOM XML Parsing Demo using : 
 * DocumentBuilderFactory, DocumentBuilder of javax.xml.parsers 
 * Document, NodeList, Node and Element of org.w3c.dom
 * Modified on : 25th Feb 2018
 */
public class XMLDomParsingDemo {

	public static void main(String[] args) {
		try{
			File inputFile = new File("D:/My Folder/MyJavaProjects/src/com/xml/Students.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();    //Create a DocumentBuilder using the DocumentBuilderFactory 
			Document doc = dBuilder.parse(inputFile);                     //Create Document parsing the xml file 
			doc.getDocumentElement().normalize();
			System.out.println("Root Elelement : " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("student");
			for (int i=0; i < nList.getLength(); i++){
				Node node = nList.item(i);
				System.out.println("Current Elelement : " + "[" + i + "] " + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE){
					Element el = (Element) node;
					System.out.println("Student Roll No : " + el.getAttribute("rollno"));
					System.out.println("First Name      : " + el.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name       : " + el.getElementsByTagName("lastname").item(0).getTextContent());					
					System.out.println("Marks           : " + el.getElementsByTagName("marks").item(0).getTextContent());
					
					if (el.getElementsByTagName("address").item(0).hasChildNodes()){  //Check If address node do not have any child nodes.
						System.out.println("HouseNo         : " + el.getElementsByTagName("houseno").item(0).getTextContent());
						System.out.println("City         : " + el.getElementsByTagName("city").item(0).getTextContent());
					}					
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
