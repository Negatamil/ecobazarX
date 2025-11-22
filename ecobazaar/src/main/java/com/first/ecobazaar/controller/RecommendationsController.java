package com.first.ecobazaar.controller;

import com.first.ecobazaar.entity.RecommendationsEntity;
import com.first.ecobazaar.service.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationsController {
    
    @Autowired
    private RecommendationsService recommendationsService;
    
    @PostMapping("/add")
    public RecommendationsEntity addRecommendation(@RequestBody RecommendationsEntity recommendation) {
        return recommendationsService.addRecommendation(recommendation);
    }
    
    @GetMapping("/user/{userId}")
    public List<RecommendationsEntity> getRecommendationsByUser(@PathVariable Long userId) {
        return recommendationsService.getRecommendationsByUser(userId);
    }
    
    @GetMapping
    public List<RecommendationsEntity> getAllRecommendations() {
        return recommendationsService.getAllRecommendations();
    }
}
