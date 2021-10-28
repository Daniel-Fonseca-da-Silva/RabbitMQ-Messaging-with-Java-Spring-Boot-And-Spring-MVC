package com.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectPublisher {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String msg = "This is to TV message!";
		
		channel.basicPublish("Direct-Exchange", "tv", null, msg.getBytes());
		
		connection.close();
		channel.close();
		
	}
}
