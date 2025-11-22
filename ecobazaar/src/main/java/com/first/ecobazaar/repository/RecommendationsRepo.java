package com.first.ecobazaar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.first.ecobazaar.entity.RecommendationsEntity;
import java.util.List;

public interface RecommendationsRepo extends JpaRepository<RecommendationsEntity, Long> {
    
    List<RecommendationsEntity> findByUserUserIdOrderByCreatedAtDesc(Long userId);
}
