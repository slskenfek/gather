package com.qather.distributed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class DistributedApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedApplication.class, args);
	}

}
