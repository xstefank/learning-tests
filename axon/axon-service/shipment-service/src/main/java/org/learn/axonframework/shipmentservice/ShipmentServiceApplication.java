package org.learn.axonframework.shipmentservice;

import com.rabbitmq.client.Channel;
import org.axonframework.amqp.eventhandling.DefaultAMQPMessageConverter;
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.serialization.Serializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShipmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShipmentServiceApplication.class, args);
	}

	@Bean
	public SpringAMQPMessageSource orderEvents(Serializer serializer) {
		return new SpringAMQPMessageSource(new DefaultAMQPMessageConverter(serializer)) {

			@RabbitListener(queues = "OrderEvents")
			@Override
			public void onMessage(Message message, Channel channel) throws Exception {
				super.onMessage(message, channel);
			}
		};
	}
}
