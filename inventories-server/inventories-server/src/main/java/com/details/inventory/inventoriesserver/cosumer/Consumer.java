package com.details.inventory.inventoriesserver.cosumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.List;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.details.inventory.inventoriesserver.entities.Inventory;
import com.details.inventory.inventoriesserver.publisher.Publisher;
import com.details.inventory.inventoriesserver.repositories.InventoryRepository;
import com.details.inventory.inventoriesserver.services.impl.InventoryServiceImpl;

public class Consumer {

	@Autowired
	InventoryRepository inventoryRepository;

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

					TextMessage textMmessage = (TextMessage) message;
					try {
						String updateddate = textMmessage.getText();
						
						Inventory inventory = inventoryRepository.findById(updateddate).get();
						
						List<String> availableSeats = inventory.getAvailableSeats();

						Publisher publisher = new Publisher();

						publisher.publishMessagetoQueue(availableSeats.toString());

					} catch (JMSException e) {
						e.printStackTrace();
					}

				}

			});

		} catch (JMSException jmxe) {
			jmxe.printStackTrace();
		}

		return message;

	}
}
