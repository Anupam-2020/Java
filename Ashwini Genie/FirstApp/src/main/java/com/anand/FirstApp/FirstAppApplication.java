package com.anand.FirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FirstAppApplication {

	public static void main(String[] args) {
		System.out.println("Anupam");
		SpringApplication.run(FirstAppApplication.class, args);
		System.out.println("Anand");

		Car car;

//		SpringApplication app = new SpringApplication(FirstAppApplication.class);
//		app.setBanner((environment, sourceClass, out) -> {
//			out.println("Custom Banner");
//		});
	}
}
