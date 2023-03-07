package com.medicorps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MedicorpsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicorpsServerApplication.class, args);
	}

}
