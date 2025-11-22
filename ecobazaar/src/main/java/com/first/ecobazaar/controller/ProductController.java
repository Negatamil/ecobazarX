
package com.first.ecobazaar.controller;

import com.first.ecobazaar.entity.ProductsEntity;
import com.first.ecobazaar.service.ProductsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductsSer productService;

    @PostMapping("/add")
    public ProductsEntity addProduct(@RequestBody ProductsEntity product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<ProductsEntity> getAll() {
        return productService.getAllProducts();
    }
    
    @PutMapping("/update")
    public ProductsEntity updateProduct(@RequestBody ProductsEntity product) {
        return productService.updateProduct(product);
    }
    
    @GetMapping("/{id}")
    public ProductsEntity getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    
    @GetMapping("/category/{categoryId}")
    public List<ProductsEntity> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }
    
    @GetMapping("/carbon-footprint/asc")
    public List<ProductsEntity> getProductsByCarbonFootprintAsc() {
        return productService.getProductsByCarbonFootprintAsc();
    }
    
    @GetMapping("/carbon-footprint/desc")
    public List<ProductsEntity> getProductsByCarbonFootprintDesc() {
        return productService.getProductsByCarbonFootprintDesc();
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
