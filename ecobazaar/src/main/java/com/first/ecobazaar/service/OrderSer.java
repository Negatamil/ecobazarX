package com.first.ecobazaar.service;

import com.first.ecobazaar.entity.OrderEntity;
import com.first.ecobazaar.entity.OrderItems;
import com.first.ecobazaar.entity.CartEntity;
import com.first.ecobazaar.repository.OrderRepo;
import com.first.ecobazaar.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class OrderSer {

    @Autowired
    private OrderRepo orderRepo;
    
    @Autowired
    private CartService cartService;

    public OrderEntity placeOrder(OrderEntity order) {
        double totalAmount = 0;
        double totalFootprint = 0;

        if (order.getItems() != null) {
            for (OrderItems item : order.getItems()) {
                totalAmount += item.getSubtotal();
                totalFootprint += item.getItemFootprint();
                item.setOrder(order); // sets the relationship
            }
        }

        order.setTotalAmount(totalAmount);
        order.setTotalFootprint(totalFootprint);
        return orderRepo.save(order);
    }
    
    public List<OrderEntity> getOrderHistoryByUser(Long userId) {
        return orderRepo.findByCustomerUserIdOrderByOrderDateDesc(userId);
    }
    
    public OrderEntity getOrderById(Long orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }
    
    public OrderEntity checkoutFromCart(Long userId) {
        List<CartEntity> cartItems = cartService.getCartItems(userId);
        
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }
        
        OrderEntity order = new OrderEntity();
        order.setCustomer(cartItems.get(0).getUser());
        
        List<OrderItems> orderItems = new ArrayList<>();
        double totalAmount = 0;
        double totalFootprint = 0;
        
        for (CartEntity cartItem : cartItems) {
            OrderItems orderItem = new OrderItems();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setSubtotal(cartItem.getSubtotal());
            
            // Calculate carbon footprint
            double itemFootprint = 0;
            if (cartItem.getProduct().getCarbonFootprint() != null) {
                itemFootprint = cartItem.getProduct().getCarbonFootprint().getCo2Emission() * cartItem.getQuantity();
            }
            orderItem.setItemFootprint(itemFootprint);
            orderItem.setOrder(order);
            
            orderItems.add(orderItem);
            totalAmount += cartItem.getSubtotal();
            totalFootprint += itemFootprint;
        }
        
        order.setItems(orderItems);
        order.setTotalAmount(totalAmount);
        order.setTotalFootprint(totalFootprint);
        
        OrderEntity savedOrder = orderRepo.save(order);
        
        // Clear cart after successful checkout
        cartService.clearCart(userId);
        
        return savedOrder;
    }
}
