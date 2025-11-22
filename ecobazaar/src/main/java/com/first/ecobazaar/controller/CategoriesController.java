package com.first.ecobazaar.controller;

import com.first.ecobazaar.entity.CategoriesEntity;
import com.first.ecobazaar.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    
    @Autowired
    private CategoriesService categoriesService;
    
    @PostMapping("/add")
    public CategoriesEntity addCategory(@RequestBody CategoriesEntity category) {
        return categoriesService.addCategory(category);
    }
    
    @GetMapping
    public List<CategoriesEntity> getAllCategories() {
        return categoriesService.getAllCategories();
    }
    
    @GetMapping("/{id}")
    public CategoriesEntity getCategoryById(@PathVariable Long id) {
        return categoriesService.getCategoryById(id);
    }
    
    @PutMapping("/update")
    public CategoriesEntity updateCategory(@RequestBody CategoriesEntity category) {
        return categoriesService.updateCategory(category);
    }
}
