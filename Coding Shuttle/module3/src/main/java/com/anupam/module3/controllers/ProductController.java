package com.anupam.module3.controllers;

import com.anupam.module3.entities.ProductEntity;
import com.anupam.module3.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final int PAGE_SIZE = 125;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<List<ProductEntity>> saveToDB(@RequestBody List<ProductEntity> product) {
        List<ProductEntity> products = productRepository.saveAll(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "") String title) {
//        return productRepository.findByOrderByPrice();
//        return productRepository.findBy(Sort.by(sortBy, "price", "quantity").descending());

//        return productRepository.findBy(Sort.by(
//                Sort.Order.desc(sortBy),
//                Sort.Order.asc("price")
//        ));

//        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy));
//        return productRepository.findAll(pageable);

        return productRepository.findByTitleContainingIgnoreCase(title, PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy)));
    }
}
