package com.first.ecobazaar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.first.ecobazaar.entity.CartEntity;
import java.util.List;

public interface CartRepo extends JpaRepository<CartEntity, Long> {
    
    List<CartEntity> findByUserUserId(Long userId);
    
    
    
    CartEntity findByUserUserIdAndProductProductId(Long userId, Long productId);
    
    void deleteByUserUserIdAndProductProductId(Long userId, Long productId);
    
    void deleteByUserUserId(Long userId);
}