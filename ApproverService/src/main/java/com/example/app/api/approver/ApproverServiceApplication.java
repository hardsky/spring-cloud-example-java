package com.example.app.api.approver;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ApproverServiceApplication {

	@Autowired
	private Environment env;

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

	public static void main(String[] args) {
		SpringApplication.run(ApproverServiceApplication.class, args);
	}

}
