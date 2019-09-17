package com.example.demo.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service
public   class MessageReceiverService  {

	   @Autowired
	    private ApplicationContext context;

	    public String findBootClass() {
	        Map<String, Object> annotatedBeans = context.getBeansWithAnnotation(SpringBootApplication.class);
	        return annotatedBeans.isEmpty() ? null : annotatedBeans.values().toArray()[0].getClass().getPackage().getName();
	    }

	public void receiveMsg(Object message) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String mesg = (String) message;

		Reflections reflections = new Reflections( 
			    new ConfigurationBuilder().setUrls( 
			    ClasspathHelper.forPackage( findBootClass()) ).setScanners(
			    new MethodAnnotationsScanner() ) );
			Set<Method> methods = reflections.getMethodsAnnotatedWith(QFXLMReceiver.class);
			for(Method m: methods) {
				m.invoke(m.getDeclaringClass().newInstance(), mesg);
			}
			
	}


		

}
