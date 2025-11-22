package com.first.ecobazaar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.first.ecobazaar.entity.OrderEntity;
import java.util.List;

public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

    OrderEntity save(OrderEntity order);
    
    List<OrderEntity> findByCustomerUserIdOrderByOrderDateDesc(Long userId);
}
