package com.example.app.api;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.example.app.api.messaging.VerificationReceiver;

import feign.Logger;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class ApiServiceApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplication.class, args);
	}

	@Bean
	Logger.Level feignLoggerLevel()
	{
		return Logger.Level.FULL;
	}
	
	@Bean
	Queue queue() {
		return new Queue(env.getProperty("api.messaging.queue-name"), false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(env.getProperty("api.messaging.topic-exchange-name"));
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(env.getProperty("api.messaging.routing.scope"));
	}

	@Bean
	MessageListenerAdapter listenerAdapter(VerificationReceiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveVerification");
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(env.getProperty("api.messaging.queue-name"));
		container.setMessageListener(listenerAdapter);
		return container;
	}
	
}
