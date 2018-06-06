package com.jms.queue;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	//URL of the JMS server. DEFAULT_BROKER_URL means that it is in localhost i.e. tcp://localhost:61616
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL; 
	private static String queueName = "KSQueue";                 //Queue Name
	
	public static void SendMessageToQueue(){
		Student st = new Student();
		st.id = 1001;
		st.name = "Kishore Sharma";
		
		try{
			//Getting the JMS connection from the server and starting it.
			QueueConnectionFactory connFactory = new ActiveMQConnectionFactory(url);
			QueueConnection conn = connFactory.createQueueConnection();
			try{
				conn.start();

				//JMS msgs are sent & received using a session. We create here a non-transactional session obj. if you want to use trasaction, first parameter should be True.
				QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
				Queue queue = session.createQueue(queueName);
				QueueSender sender = session.createSender(queue);

				//TextMessage message = session.createTextMessage("Hello this is test message 4.");
				ObjectMessage objMessage = session.createObjectMessage(st);
				sender.send(objMessage);
//				sender.send(message);
				System.out.println("Producer : Message is sent.");
			}finally {
				conn.close();
			}
		}catch (JMSException e){
			System.out.println(e.getMessage());
		}		

	}
	
	public static void main(String[] args) {
		SendMessageToQueue();
	}

}
