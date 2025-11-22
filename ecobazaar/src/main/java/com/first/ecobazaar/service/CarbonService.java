
package com.first.ecobazaar.service;

import com.first.ecobazaar.entity.CarbonEntity;
import com.first.ecobazaar.repository.CarbonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarbonService {
    @Autowired
    private CarbonRepo repo;

    public CarbonEntity addFootprint(CarbonEntity carbon) {
        return repo.save(carbon);
    }

    public List<CarbonEntity> getAllFootprints() {
        return repo.findAll();
    }
    
    public CarbonEntity updateFootprint(CarbonEntity carbon) {
        return repo.save(carbon);
    }
    
    public CarbonEntity getFootprintByProductId(Long productId) {
        return repo.findByProductProductId(productId);
    }
}
