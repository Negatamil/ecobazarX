
package com.first.ecobazaar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;
    private double price;
    private String description;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private UserEntity vendor;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoriesEntity category;
    
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private CarbonEntity carbonFootprint;

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public UserEntity getVendor() {
        return vendor;
    }
    
    public void setVendor(UserEntity vendor) {
        this.vendor = vendor;
    }
    
    public CategoriesEntity getCategory() {
        return category;
    }
    
    public void setCategory(CategoriesEntity category) {
        this.category = category;
    }
    
    public CarbonEntity getCarbonFootprint() {
        return carbonFootprint;
    }
    
    public void setCarbonFootprint(CarbonEntity carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }
}
