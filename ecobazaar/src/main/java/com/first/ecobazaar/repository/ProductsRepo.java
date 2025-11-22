
package com.first.ecobazaar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.first.ecobazaar.entity.ProductsEntity;

public interface ProductsRepo extends JpaRepository<ProductsEntity, Long> {

    ProductsEntity save(ProductsEntity product);

    List<ProductsEntity> findAll();
    
    List<ProductsEntity> findByCategoryCategoryId(Long categoryId);
    
    @Query("SELECT p FROM ProductsEntity p LEFT JOIN p.carbonFootprint c ORDER BY c.co2Emission ASC")
    List<ProductsEntity> findAllOrderByCarbonFootprintAsc();
    
    @Query("SELECT p FROM ProductsEntity p LEFT JOIN p.carbonFootprint c ORDER BY c.co2Emission DESC")
    List<ProductsEntity> findAllOrderByCarbonFootprintDesc();
}
