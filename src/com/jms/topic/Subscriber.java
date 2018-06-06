package com.jms.topic;

import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Subscriber {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL; 
	private static String topicName = "MyTestTopic";         //Topic Name
	
	public static void main(String[] args) {
		try{
			TopicConnectionFactory connFactory = new ActiveMQConnectionFactory(url);
			TopicConnection conn = connFactory.createTopicConnection();
			conn.start();
			
			TopicSession session = conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic(topicName);
			TopicSubscriber subscriber = session.createSubscriber(topic);

			MyListener listener = new MyListener();
			subscriber.setMessageListener(listener);
			System.out.println("Subscriber is ready and waiting for messages.");
			System.out.println("Press Ctrl + C to shutdown.");

			while (true){
				Thread.sleep(1000);
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
