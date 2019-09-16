package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.jms.annotation.EnableJms;

import com.example.demo.services.AMQSender;

@SpringBootApplication
@EnableJms
@EnableIntegration
@ImportResource("classpath*:/springintegration-config.xml")
public class DemoApplication implements CommandLineRunner {


	@Autowired
	AMQSender aMQSender;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
//		aMQReceiver.processMsg(msg);
//		Deal d = new Deal("Dd",2334);
		aMQSender.send("fxgfg");
		System.out.println("sending successfully");

		
//		String rec = aMQReceiver.receiveMsg();
	}
	


}
