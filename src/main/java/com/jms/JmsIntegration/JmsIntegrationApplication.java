package com.jms.JmsIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class)
@EnableJms
@EnableFeignClients
public class JmsIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsIntegrationApplication.class, args);
	}

}
