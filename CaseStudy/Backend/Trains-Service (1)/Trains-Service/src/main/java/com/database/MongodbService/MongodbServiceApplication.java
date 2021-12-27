package com.database.MongodbService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableSwagger2
@EnableEurekaClient
public class MongodbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbServiceApplication.class, args);
	}

}
