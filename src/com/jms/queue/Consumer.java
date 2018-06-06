package com.jms.queue;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {	
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL; 
	private static String queueName = "KSQueue";                 //Queue Name	
	
	public static void ConsumeMessage(){
		try{
			ActiveMQConnectionFactory connFactory = new ActiveMQConnectionFactory(url);
			//The setTrustAllPackages() allows you to turn off security check and trust all classes. It's useful for testing purposes.
			connFactory.setTrustAllPackages(true);
			QueueConnection conn = connFactory.createQueueConnection();
			conn.start();

			QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue(queueName);
			QueueReceiver receiver = session.createReceiver(queue);
			
			//a. Receiving messages using MessageListener
			MyListener listener = new MyListener();
			receiver.setMessageListener(listener);
			System.out.println("Receiver is ready to receive message.");
			System.out.println("Press Ctrl + C to shutdown.");

			while(true){
				Thread.sleep(1000);
			}

			//b. Instantly consuming the message and closing the connection.
//			Message message = receiver.receive();
//			if (message instanceof TextMessage){
//				TextMessage textMessage = (TextMessage) message;
//				System.out.println("Received message is = " + textMessage.getText());
//			}
//			conn.close(); 

		}catch (JMSException|InterruptedException e){
			System.out.println(e.getMessage());
		}
	}
		
	public static void main(String[] args) {
		ConsumeMessage();
	}

}
