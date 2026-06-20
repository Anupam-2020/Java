package com.anupam.springSecurity;

import com.anupam.springSecurity.entities.User;
import com.anupam.springSecurity.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {

		User user = User.builder().id(4L).email("anupam@gmail.com").password("1234").build();

		String token = jwtService.generateAccessToken(user);

		System.out.println("token -> "+token);

		Long id = jwtService.getUserIdFromToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0IiwiZW1haWwiOiJhbnVwYW1AZ21haWwuY29tIiwicm9sZXMiOlsiVVNFUiIsIkFETUlOIl0sImlhdCI6MTc4MTc3NjYwMiwiZXhwIjoxNzgxNzc2NjYyfQ.ZywWA-TY1zixhFWBO__hgzscclAhTbZ8xh1Ubbo5oLpyeXXFMgJOnRszlIHSddx0d-ThPsAtAtOcySPDUWEQhQ");

		System.out.println("id -> "+id);

	}

}
