package com.anupam.ecom_application.service;

import com.anupam.ecom_application.dto.CartItemRequestDto;
import com.anupam.ecom_application.model.CartItem;
import com.anupam.ecom_application.model.Product;
import com.anupam.ecom_application.model.User;
import com.anupam.ecom_application.repository.CartItemRepository;
import com.anupam.ecom_application.repository.ProductRepository;
import com.anupam.ecom_application.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

//    public CartService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public boolean addToCart(String userId, CartItemRequestDto request) {
        // look for product.
        Optional<Product> productOpt = productRepository.findById(request.getProductId());
        if(productOpt.isEmpty()) return false;

        Product product = productOpt.get();
        if(product.getStockQuantity() < request.getQuantity()) return  false;

        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if(userOpt.isEmpty()) return false;

        User user = userOpt.get();

        CartItem existingCartItem = cartItemRepository.findByUserAndProduct(user, product);
        if(existingCartItem != null) {
            // update the quantity.
            existingCartItem.setQuantity(existingCartItem.getQuantity() + request.getQuantity());
            existingCartItem.setPrice(product.getPrice().multiply(existingCartItem.getPrice()));
            cartItemRepository.save(existingCartItem);
        } else {
            // Create new cart item.
            CartItem cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(request.getQuantity());
            cartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity())));
            cartItemRepository.save(cartItem);
        }

        return true;
    }

    public boolean deleteItemFromCart(String userId, Long productId) {
        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        Optional<Product> productOpt = productRepository.findById(productId);

        if(productOpt.isPresent() && userOpt.isPresent()) {
            cartItemRepository.deleteByUserAndProduct(userOpt.get(), productOpt.get());
            return true;
        }

        return false;
    }

    public List<CartItem> getCart(String userId) {
        return userRepository.findById(Long.valueOf(userId))
                .map((user) -> cartItemRepository.findByUser(user))
                .orElseGet(() -> List.of());
    }

    public void clearCart(String userId) {
        userRepository.findById(Long.valueOf(userId)).ifPresent(user -> cartItemRepository.deleteByUser(user));
    }
}
