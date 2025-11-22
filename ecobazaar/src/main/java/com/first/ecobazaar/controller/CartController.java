package com.first.ecobazaar.controller;

import com.first.ecobazaar.entity.CartEntity;
import com.first.ecobazaar.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;
    
    @PostMapping("/add")
    public CartEntity addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        return cartService.addToCart(userId, productId, quantity);
    }
    
    @GetMapping("/user/{userId}")
    public List<CartEntity> getCartItems(@PathVariable Long userId) {
        return cartService.getCartItems(userId);
    }
    
    @PutMapping("/update")
    public CartEntity updateCartItem(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        return cartService.updateCartItem(userId, productId, quantity);
    }
    
    @DeleteMapping("/remove")
    public String removeFromCart(@RequestParam Long userId, @RequestParam Long productId) {
        cartService.removeFromCart(userId, productId);
        return "Item removed from cart";
    }
    
    @DeleteMapping("/clear/{userId}")
    public String clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return "Cart cleared";
    }
}