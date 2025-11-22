package com.first.ecobazaar.service;

import com.first.ecobazaar.entity.CategoriesEntity;
import com.first.ecobazaar.repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriesService {
    
    @Autowired
    private CategoriesRepo categoriesRepo;
    
    public CategoriesEntity addCategory(CategoriesEntity category) {
        return categoriesRepo.save(category);
    }
    
    public List<CategoriesEntity> getAllCategories() {
        return categoriesRepo.findAll();
    }
    
    public CategoriesEntity getCategoryById(Long id) {
        return categoriesRepo.findById(id).orElse(null);
    }
    
    public CategoriesEntity updateCategory(CategoriesEntity category) {
        return categoriesRepo.save(category);
    }
}