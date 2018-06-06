package com.jms.topic;

import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.jms.queue.Student;

public class Publisher {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL; 
	private static String topicName = "MyTestTopic";         //Topic Name
	
	public static void main(String[] args) {
		Student st = new Student();
		st.setId(1001);
		st.setName("Kishore Sharma");
		
		try{
			TopicConnectionFactory connFactory = new ActiveMQConnectionFactory(url);
			TopicConnection conn = connFactory.createTopicConnection();
			conn.start();
			
			TopicSession session = conn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic(topicName);			
			TopicPublisher publisher = session.createPublisher(topic);
			
			TextMessage msg = session.createTextMessage("Hello, test message publishng to all subscribers.");
			publisher.publish(msg);
			
			System.out.println("Message published successfully.");
			conn.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}

	}


}
