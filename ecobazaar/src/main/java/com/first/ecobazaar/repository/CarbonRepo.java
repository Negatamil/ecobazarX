
package com.first.ecobazaar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.first.ecobazaar.entity.CarbonEntity;

public interface CarbonRepo extends JpaRepository<CarbonEntity, Long> {

    CarbonEntity save(CarbonEntity carbon);

    List<CarbonEntity> findAll();
    
    CarbonEntity findByProductProductId(Long productId);
}
