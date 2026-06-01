package com.anand.module1;

import com.anand.module1.assignment.CakeBaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {

//	@Autowired // field DI(Not recommended)
//	NotificationService notificationService;

//	public Module1Application(NotificationService notificationService) {
//		this.notificationService = notificationService; // constructor DI(Recommended).
//	}

	@Autowired
	Map<String, NotificationService> notificationServiceMap = new HashMap<>(); // to get all the instances of bean, we can use Map.

	private final CakeBaker cakeBaker;

    public Module1Application(CakeBaker cakeBaker) {
        this.cakeBaker = cakeBaker;
    }

    public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		notificationService.send("Message sent");

		for(var notificationService: notificationServiceMap.entrySet()) {
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("");
			cakeBaker.bakeCake();
		}
	}
}
