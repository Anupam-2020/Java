package com.anupam.ecommerce.inventory_service.service;

import com.anupam.ecommerce.inventory_service.dto.OrderRequestDto;
import com.anupam.ecommerce.inventory_service.dto.OrderRequestItemDto;
import com.anupam.ecommerce.inventory_service.dto.ProductDto;
import com.anupam.ecommerce.inventory_service.entity.Product;
import com.anupam.ecommerce.inventory_service.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public List<ProductDto> getAllInventory() {
        log.info("Fetching all inventory items");
        List<Product> inventories = productRepository.findAll();

        return inventories.stream()
                .map((element) -> mapper.map(element, ProductDto.class))
                .toList();
    }

    public ProductDto getProductById(Long id) {
        log.info("Fetching product with ID: {}", id);

        Optional<Product> inventory = productRepository.findById(id);

        return inventory.map(item -> mapper.map(item, ProductDto.class))
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
    }

    @Transactional
    public Double reduceStocks(OrderRequestDto orderRequestDto) {
        log.info("Reducing stocks");
        double totalPrice = 0.0;
        for(OrderRequestItemDto orderRequestItemDto: orderRequestDto.getItems()) {
            Long productId = orderRequestItemDto.getProductId();
            Integer quantity = orderRequestItemDto.getQuantity();

            Product product = productRepository.findById(productId).orElseThrow(() ->
                    new RuntimeException("Product not found with id: "+productId));

            if(product.getStock() < quantity) {
                throw new RuntimeException("product not sufficient in inventory");
            }

            product.setStock(product.getStock() - quantity);
            totalPrice += quantity * product.getPrice();
        }

        return totalPrice;
    }
}
