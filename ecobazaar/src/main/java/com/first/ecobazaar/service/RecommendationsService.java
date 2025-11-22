package com.first.ecobazaar.service;

import com.first.ecobazaar.entity.RecommendationsEntity;
import com.first.ecobazaar.repository.RecommendationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecommendationsService {
    
    @Autowired
    private RecommendationsRepo recommendationsRepo;
    
    public RecommendationsEntity addRecommendation(RecommendationsEntity recommendation) {
        return recommendationsRepo.save(recommendation);
    }
    
    public List<RecommendationsEntity> getRecommendationsByUser(Long userId) {
        return recommendationsRepo.findByUserUserIdOrderByCreatedAtDesc(userId);
    }
    
    public List<RecommendationsEntity> getAllRecommendations() {
        return recommendationsRepo.findAll();
    }
}