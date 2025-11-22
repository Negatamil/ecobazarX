
package com.first.ecobazaar.service;

import com.first.ecobazaar.entity.ProductsEntity;
import com.first.ecobazaar.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsSer {
    @Autowired
    private ProductsRepo repo;

    public ProductsEntity addProduct(ProductsEntity product) {
        return repo.save(product);
    }

    public List<ProductsEntity> getAllProducts() {
        return repo.findAll();
    }
    
    public ProductsEntity updateProduct(ProductsEntity product) {
        return repo.save(product);
    }
    
    public ProductsEntity getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    public List<ProductsEntity> getProductsByCategory(Long categoryId) {
        return repo.findByCategoryCategoryId(categoryId);
    }
    
    public List<ProductsEntity> getProductsByCarbonFootprintAsc() {
        return repo.findAllOrderByCarbonFootprintAsc();
    }
    
    public List<ProductsEntity> getProductsByCarbonFootprintDesc() {
        return repo.findAllOrderByCarbonFootprintDesc();
    }
    
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
