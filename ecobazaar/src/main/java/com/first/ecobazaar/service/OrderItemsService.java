package com.first.ecobazaar.service;

import com.first.ecobazaar.entity.OrderItems;
import com.first.ecobazaar.entity.ProductsEntity;
import com.first.ecobazaar.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsService {
    
    @Autowired
    private ProductsRepo productsRepo;
    
    public OrderItems calculateOrderItem(Long productId, int quantity) {
        ProductsEntity product = productsRepo.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        
        OrderItems orderItem = new OrderItems();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        
        double subtotal = product.getPrice() * quantity;
        orderItem.setSubtotal(subtotal);
        
        double itemFootprint = 0;
        if (product.getCarbonFootprint() != null) {
            itemFootprint = product.getCarbonFootprint().getCo2Emission() * quantity;
        }
        orderItem.setItemFootprint(itemFootprint);
        
        return orderItem;
    }
}