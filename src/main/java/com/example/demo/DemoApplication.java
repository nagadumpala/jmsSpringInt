package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.services.AMQSender;
import com.example.demo.services.QFXLMReceiver;

@SpringBootApplication
@QFXLMmessaging
public class DemoApplication implements CommandLineRunner {

	
	@Autowired
	AMQSender aMQSender;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		aMQSender.send("dndndnn");
		System.out.println("sending successfully");
	}
	
	@QFXLMReceiver
	public void receiveMsg(Object message) {
		
		String mesg = (String) message;
		
		System.out.println("received " + mesg);

	}

}
