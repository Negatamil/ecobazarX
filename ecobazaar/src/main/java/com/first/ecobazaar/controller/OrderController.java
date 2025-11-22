
package com.first.ecobazaar.controller;

import com.first.ecobazaar.entity.OrderEntity;
import com.first.ecobazaar.entity.OrderItems;
import com.first.ecobazaar.entity.UserEntity;
import com.first.ecobazaar.service.OrderSer;
import com.first.ecobazaar.service.OrderItemsService;
import com.first.ecobazaar.service.UserSer;
import com.first.ecobazaar.dto.OrderRequestDTO;
import com.first.ecobazaar.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderSer orderService;
    
    @Autowired
    private OrderItemsService orderItemsService;
    
    @Autowired
    private UserSer userService;

    @PostMapping("/place")
    public OrderEntity placeOrder(@RequestBody OrderRequestDTO orderRequest) {
        UserEntity user = userService.getUserById(orderRequest.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        
        OrderEntity order = new OrderEntity();
        order.setCustomer(user);
        
        List<OrderItems> orderItems = new ArrayList<>();
        for (OrderItemDTO itemDTO : orderRequest.getItems()) {
            OrderItems orderItem = orderItemsService.calculateOrderItem(itemDTO.getProductId(), itemDTO.getQuantity());
            orderItems.add(orderItem);
        }
        
        order.setItems(orderItems);
        return orderService.placeOrder(order);
    }
    
    @GetMapping("/user/{userId}")
    public List<OrderEntity> getOrderHistory(@PathVariable Long userId) {
        return orderService.getOrderHistoryByUser(userId);
    }
    
    @GetMapping("/{orderId}")
    public OrderEntity getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }
    
    @PostMapping("/checkout/{userId}")
    public OrderEntity checkoutFromCart(@PathVariable Long userId) {
        return orderService.checkoutFromCart(userId);
    }
}
