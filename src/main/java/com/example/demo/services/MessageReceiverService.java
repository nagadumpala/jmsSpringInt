package com.example.demo.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.jms.TextMessage;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
public class MessageReceiverService  {

	
	public void receiveMsg(Object message) {
		if(message instanceof TextMessage) {
			System.out.println("text messa");
		}
		String mesg = (String) message;
	}

}
