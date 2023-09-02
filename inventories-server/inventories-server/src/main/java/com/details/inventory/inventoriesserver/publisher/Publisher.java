package com.details.inventory.inventoriesserver.publisher;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
	
	public Publisher(){
		
	}
	
	public String publishMessagetoQueue(String message) {
		
		ConnectionFactory factory = new ActiveMQConnectionFactory("amin","admin","tcp://localhost:61616");
		
		try {
			
		Connection connection = factory.createConnection();
		
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue("InterProcessCommunication");
		
		TextMessage TextMessage = session.createTextMessage("Communication starting...");
		
		MessageProducer producer = session.createProducer(destination);
		
		producer.send(TextMessage);
		
		session.close();
		
		connection.close();
		
		
			
		}catch(JMSException jmxe)
		{
			jmxe.printStackTrace();
		}
		
		return message;
		
		}
	

}




