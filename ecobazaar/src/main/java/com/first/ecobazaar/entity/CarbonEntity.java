
package com.first.ecobazaar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carbon_footprints")
public class CarbonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long footprintId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductsEntity product;

    private double co2Emission;
    private double energyUsed;
    private double waterUsed;

    // Getters and Setters
    public Long getFootprintId() {
        return footprintId;
    }
    
    public void setFootprintId(Long footprintId) {
        this.footprintId = footprintId;
    }
    
    public ProductsEntity getProduct() {
        return product;
    }
    
    public void setProduct(ProductsEntity product) {
        this.product = product;
    }
    
    public double getCo2Emission() {
        return co2Emission;
    }
    
    public void setCo2Emission(double co2Emission) {
        this.co2Emission = co2Emission;
    }
    
    public double getEnergyUsed() {
        return energyUsed;
    }
    
    public void setEnergyUsed(double energyUsed) {
        this.energyUsed = energyUsed;
    }
    
    public double getWaterUsed() {
        return waterUsed;
    }
    
    public void setWaterUsed(double waterUsed) {
        this.waterUsed = waterUsed;
    }
}
