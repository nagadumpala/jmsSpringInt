package com.example.demo.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Service
@Log4j2
public class ExceptionHandler implements ErrorHandler {

	@Override
	public void handleError(Throwable t) {

		if (t instanceof MessageHandlingException) {
            MessageHandlingException exception = (MessageHandlingException) t;
            if (exception != null) {
                org.springframework.messaging.Message<?> message = exception.getFailedMessage();
                Object payloadObject = message.getPayload();
                if (null != payloadObject) {
                	System.out.println("exception " + exception.getMessage());

                	System.out.println("Payload  is not null, type is: " + payloadObject);
//                    LOG.info("Payload  is not null, type is: " + payloadObject);
                }
            }
        } else {
//            log.info("Exception is not of type: MessageHandlingException ");
        }		
	}

}
