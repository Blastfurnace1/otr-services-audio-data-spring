package com.blastfurnace.otr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@ServletComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class AudioDataApplication extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(AudioDataApplication.class);
	
	public static void main(String[] args) {
		log.warn("Starting App");
		SpringApplication.run(AudioDataApplication.class, args);
	}

}
