package com.first.ecobazaar.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recommendations")
public class RecommendationsEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductsEntity recommendedProduct;
    
    private String reason; // Why this product is recommended
    private double ecoScore; // Environmental score
    private LocalDateTime createdAt = LocalDateTime.now();
    
    // Getters and Setters
    public Long getRecommendationId() {
        return recommendationId;
    }
    
    public void setRecommendationId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }
    
    public UserEntity getUser() {
        return user;
    }
    
    public void setUser(UserEntity user) {
        this.user = user;
    }
    
    public ProductsEntity getRecommendedProduct() {
        return recommendedProduct;
    }
    
    public void setRecommendedProduct(ProductsEntity recommendedProduct) {
        this.recommendedProduct = recommendedProduct;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public double getEcoScore() {
        return ecoScore;
    }
    
    public void setEcoScore(double ecoScore) {
        this.ecoScore = ecoScore;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
