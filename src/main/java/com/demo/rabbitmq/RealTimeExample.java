package com.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RealTimeExample {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		JSONObject json = new JSONObject();
		json.put("from_date", "01-Jan-2020");
		json.put("to_date", "31-DEC-2020");
		json.put("email", "email@gmail.com");
		json.put("query", "SELECT * FROM data");

		channel.basicPublish("", "Queue-1", null, json.toString().getBytes());
		channel.close();
		connection.close();
	}

}
