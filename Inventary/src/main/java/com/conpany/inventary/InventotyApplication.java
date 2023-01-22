package com.conpany.inventary;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.juli.logging.LogFactory;

@SpringBootApplication
public class InventotyApplication implements CommandLineRunner{

	@Autowired
	private Log logger = LogFactory.getLog(InventotyApplication.class)
	
	public static void main(String[] args) {
		SpringApplication.run(InventotyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Servidor deplegado sin complecaciones");
		
	}

}
