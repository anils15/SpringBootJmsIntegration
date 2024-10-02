package com.jms.JmsIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jms.JmsIntegration.service.MessageProducer;

@RestController
public class MessageProducerController {
	@Autowired
	private MessageProducer messageProducer;

	@GetMapping("/send-message")
	public void sendMessage() {
		messageProducer.sendMessage("Hello, World!");
	}
}
