package com.anupam.module2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The @ComponentScan annotation in the Spring framework automatically looks through specified Java packages to find classes marked with annotations like @Component, @Service, @Repository, and @Controller. It tells Spring to convert these classes into managed "beans" and wire them together, eliminating the need to declare them manually.
@SpringBootApplication
public class Module2Application {

	public static void main(String[] args) {
		SpringApplication.run(Module2Application.class, args);
	}

}
