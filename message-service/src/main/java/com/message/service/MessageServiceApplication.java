package com.message.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@Slf4j
@SpringBootApplication
public class MessageServiceApplication {

	@RabbitListener(queues = {"${msvc.queue.name}"})
	public void recibirMensajeConRabbitMQ(String mensaje) {
		log.info("Mensaje Recibido {}", mensaje);
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageServiceApplication.class, args);
	}

}
