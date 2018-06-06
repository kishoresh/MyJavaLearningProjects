package com.SOAP;

/*
 * Create a SOAP msg with javax.xml.soap.* classes 
 * URL : http://www.jitendrazaa.com/blog/java/create-soap-message-using-java/
 * 
  <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
  <SOAP-ENV:Header>Training Details</SOAP-ENV:Header>
	<SOAP-ENV:Body>
    <training:Java xmlns:training="http://JitendraZaa.com/blog">
        <WS>Training on Web Services.</WS>
	</training:Java>
	<training:Java xmlns:training="http://JitendraZaa.com/blog">
		<Spring>Training on Spring.</Spring>
	</training:Java>
	</SOAP-ENV:Body>
  </SOAP-ENV:Envelope>
 */
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class CreateSOAPMessage {

	public static void main(String[] args) {
		try{
			MessageFactory msgFactory = MessageFactory.newInstance();
			SOAPMessage soapMsg = msgFactory.createMessage();
			SOAPPart soapPart = soapMsg.getSOAPPart();         //Container for the SOAP specific message.

			SOAPEnvelope envelope = soapPart.getEnvelope();
			SOAPHeader header = envelope.getHeader();
			SOAPBody body = envelope.getBody();

			header.addTextNode("Training Details");
			SOAPBodyElement element = body.addBodyElement(envelope.createName("Java", "training", "http://JitendraZaa.com/blog"));		
			element.addChildElement("WS").addTextNode("Training on Web Services.");

			SOAPBodyElement element2 = body.addBodyElement(envelope.createName("Java", "training", "http://JitendraZaa.com/blog"));
			element2.addChildElement("Spring").addTextNode("Training on Spring.");
			
			soapMsg.writeTo(System.out);
			
			FileOutputStream fout = new FileOutputStream("SOAPMessage.xml");
			soapMsg.writeTo(fout);
		}catch (SOAPException|IOException e){
			e.printStackTrace();
		}

	}

}
