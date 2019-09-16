package com.example.demo;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ImportResource;

@Retention(RUNTIME)
@Target(TYPE)
@ImportResource("classpath*:/springintegration-config.xml")
public @interface QFXLMmessaging {

}
