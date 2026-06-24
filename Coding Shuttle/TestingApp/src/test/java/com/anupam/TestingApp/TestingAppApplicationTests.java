package com.anupam.TestingApp;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
class TestingAppApplicationTests {

	@BeforeAll
	static void setUpOnce() {
		log.info("SetUp once...");
	}

	@BeforeEach
	void setUp() {
		log.info("Starting the method, setting up config.");
	}

	@AfterEach
	void tearDown() {
		log.info("Tearing down the method.");
	}

	@Test
//	@Disabled
	void contextLoads() {
		log.info("test one is run");
	}

	@Test
	void testNumberOne() {
		int a = 10;
		int b = 10;

		int result = addTwoNumbers(a, b);

//		Assertions.assertEquals(20, result);

//		Assertions.assertThat(result)
//				.isEqualTo(17)
//				.isCloseTo(21, Offset.offset(1)); // Offset.offset(1) means the result can be within 1 unit of 21, so it can be 20 or 22 as well.

		assertThat("Apple")
				.isEqualTo("Apple")
				.startsWith("pp")
				.endsWith("le")
				.hasSize(5);
	}

	@Test
	@DisplayName("displayTestNameTwo")
	void testNumberTwo() {
		log.info("test two is run");

		int a = 4;
		int b = 0;

		double result = divideTwoNumbers(a, b);
		System.out.println(result);
	}

	@AfterAll
	static void tearingDownOnce() {
		log.info("tearing down once");
	}

	int addTwoNumbers(int a, int b) {
		return a + b;
	}

	double divideTwoNumbers(int a, int b) {
		try {
			return (double) a / b;
		} catch (ArithmeticException ex) {
			log.error("Arithmetic Exception occured: "+ ex.getLocalizedMessage());
			throw new ArithmeticException(ex.getLocalizedMessage());
		}
	}
}
