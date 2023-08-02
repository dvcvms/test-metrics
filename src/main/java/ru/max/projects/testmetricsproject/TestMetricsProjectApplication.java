package ru.max.projects.testmetricsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestMetricsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestMetricsProjectApplication.class, args);
	}

}
