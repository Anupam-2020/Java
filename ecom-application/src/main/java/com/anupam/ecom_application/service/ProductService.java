package com.anupam.ecom_application.service;

import com.anupam.ecom_application.dto.ProductRequestDto;
import com.anupam.ecom_application.dto.ProductResponseDto;
import com.anupam.ecom_application.model.Product;
import com.anupam.ecom_application.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto productRequest) {
        Product product = new Product();
        updateProductFromRequest(product, productRequest);
        Product savedProduct = productRepository.save(product);
        return mapToProductResponse(savedProduct);
    }

    private ProductResponseDto mapToProductResponse(Product savedProduct) {
        ProductResponseDto productResponse = new ProductResponseDto();
        productResponse.setName(savedProduct.getName());
        productResponse.setId(savedProduct.getId());
        productResponse.setActive(savedProduct.getActive());
        productResponse.setPrice(savedProduct.getPrice());
        productResponse.setCategory(savedProduct.getCategory());
        productResponse.setImageUrl(savedProduct.getImageUrl());
        productResponse.setDescription(savedProduct.getDescription());
        productResponse.setStockQuantity(savedProduct.getStockQuantity());

        return productResponse;
    }

    private void updateProductFromRequest(Product product, ProductRequestDto productRequest) {
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
        product.setImageUrl(productRequest.getImageUrl());
        product.setDescription(productRequest.getDescription());
        product.setStockQuantity(productRequest.getStockQuantity());
    }

    public Optional<ProductResponseDto> updateProduct(Long id, ProductRequestDto productRequest) {
        return productRepository.findById(id)
            .map(existingProduct -> {
                updateProductFromRequest(existingProduct, productRequest);
                Product savedProduct = productRepository.save(existingProduct);
                return mapToProductResponse(savedProduct);
            });
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findByActiveTrue();
//        List<ProductResponseDto> productResponseDto = products.stream()
//                .map(product -> mapToProductResponse(product))
//                .collect(Collectors.toList());
//        return productResponseDto;

        return products.stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    public boolean deleteProduct(Long id) {
        return productRepository.findById(id).map(product -> {
            product.setActive(false);
            productRepository.save(product);
            return true;
        }).orElse(false);
    }

    public List<ProductResponseDto> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword).stream()
                .map(product -> mapToProductResponse(product))
                .collect(Collectors.toList());
    }
}
