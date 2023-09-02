package com.details.payment.paymentssserver.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.details.payment.paymentsserver.publisher.Publisher;
import com.details.payment.paymentssserver.entities.Payment;
import com.details.payment.paymentssserver.repositories.PaymentRepository;
import com.details.payment.paymentssserver.services.PaymentService;


public class Consumer {
	
	@Autowired
	PaymentService paymentService;

	public Consumer() {
	}

	public String publishMessagetoQueue(String message) {

		ConnectionFactory factory = new ActiveMQConnectionFactory("amin", "admin", "tcp://localhost:61616");

		try {

			Connection connection = factory.createConnection();

			connection.start();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue("InterProcessCommunication");

			MessageConsumer consumer = session.createConsumer(destination);

			consumer.setMessageListener(new MessageListener() {

				@Override
				public void onMessage(Message message) {
					
					TextMessage textMmessage = (TextMessage)message;
					try {
						String orderid = textMmessage.getText();
						
						Payment payment = paymentService.getPayment(orderid);
						
						Publisher publisher = new Publisher();
						
						publisher.publishMessagetoQueue(payment.getDateOfPayment());
						
					} catch (JMSException e) {
						e.printStackTrace();
					}

				}

			});

		} catch (JMSException jmxe) {
			jmxe.printStackTrace();
		}
		
		return "";

	}
}
