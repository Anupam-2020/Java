package com.anupam.module3.repositories;

import com.anupam.module3.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitle(String pepsi);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal price);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleContaining(String title);

    @Query("SELECT e.title FROM ProductEntity e WHERE e.title=?1 AND e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    List<ProductEntity> findByTitleOrderByPrice(String title);

    List<ProductEntity> findByOrderByPrice();

    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
