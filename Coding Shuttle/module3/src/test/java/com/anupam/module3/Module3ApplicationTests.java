package com.anupam.module3;

import com.anupam.module3.entities.ProductEntity;
import com.anupam.module3.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Module3ApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void testRepository() {
		ProductEntity product = ProductEntity.builder()
				.sku("Tnestle234")
				.title("Tnestle chocolate")
				.price(BigDecimal.valueOf(23.45))
				.quantity(4)
				.build();
		ProductEntity savedProductEntity = productRepository.save(product);
//		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository() {
		List<ProductEntity> entities = productRepository.findAll();
//		System.out.println(entities);
	}

	@Test
	void getByTitle() {
		List<ProductEntity> entities = productRepository.findByTitle("pepsi");
//		System.out.println(entities);
	}

	@Test
	void getByCreatedAfter() {
		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
				LocalDateTime.of(
						2026, 1, 3, 0, 0, 0
				)
		);
//		System.out.println(entities);
	}

	@Test
	void getListBasedOnFilter() {
		List<ProductEntity> entities = productRepository.findByQuantityAndPrice(4, BigDecimal.valueOf(23.45));
//		System.out.println(entities);
	}

	@Test
	void getByTitleContains() {
		List<ProductEntity> entities = productRepository.findByTitleContaining("pepsi");
		System.out.println(entities);
	}

//	@Test
//	void getByTitleAndPrice() {
//		Optional<ProductEntity> entities = productRepository.findByTitleAndPrice("pepsi", BigDecimal.valueOf(123.45));
//		System.out.println(entities);
//	}
}
