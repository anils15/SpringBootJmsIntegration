package com.jms.JmsIntegration.config;

import java.util.Arrays;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class BrokerConfig {
	
    //private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    
    private static final String ORDER_QUEUE = "test.queue";
	
    @Bean
	public BrokerService broker() throws Exception {
		BrokerService brokerService = new BrokerService();
		brokerService.setPersistent(false);
		brokerService.addConnector("tcp://localhost:61616");
		return brokerService;
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		//connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.setTrustedPackages(Arrays.asList("com.jms.JmsIntegration", "java.util"));
		return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(ORDER_QUEUE);
		return template;
	}

}
