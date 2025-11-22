package com.first.ecobazaar.controller;

import com.first.ecobazaar.entity.CarbonEntity;
import com.first.ecobazaar.service.CarbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carbon")
public class CarbonFootprintsController {
    @Autowired
    private CarbonService carbonService;

    @PostMapping("/add")
    public CarbonEntity addFootprint(@RequestBody CarbonEntity carbon) {
        return carbonService.addFootprint(carbon);
    }

    @GetMapping
    public List<CarbonEntity> getAll() {
        return carbonService.getAllFootprints();
    }
    
    @PutMapping("/update")
    public CarbonEntity updateFootprint(@RequestBody CarbonEntity carbon) {
        return carbonService.updateFootprint(carbon);
    }
    
    @GetMapping("/product/{productId}")
    public CarbonEntity getFootprintByProduct(@PathVariable Long productId) {
        return carbonService.getFootprintByProductId(productId);
    }
}

