package com.jms.JmsIntegration.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.jms.JmsIntegration.feign.CPDFeignClient;
import com.jms.JmsIntegration.model.User;

@Component
public class MessageConsumer {

	@Autowired
	CPDFeignClient client;

	@JmsListener(destination = "test.queue")
	public void receiveMessage(String message) {
		List<User> allUser = client.getAllUser();
		for (User user : allUser) {
			System.out.println("Received message: " + user.getId() + "/n" + user.getName() + "/n" + user.getEmail()
					+ "/n" + user.getAge());
		}

	}
}
