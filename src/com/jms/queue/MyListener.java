package com.jms.queue;
/*
 * Listener class overiding the onMessage() event to process the message.
 */
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class MyListener implements MessageListener {

	@Override
	public void onMessage(Message m) {
		try{
			//TextMessage msg = (TextMessage) m;      //Can be uncommented for plain text msgs.
			ObjectMessage objMsg = (ObjectMessage) m;
			Student st = (Student) objMsg.getObject();
			//System.out.println("Message received by MessageListener : " + msg.getText());  //Can be uncommented for plain text msgs.
			System.out.println("Message received by MessageListener : " + st.name);
		}catch (JMSException e){
			e.printStackTrace();
		}
	}

}
