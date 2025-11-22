package com.first.ecobazaar.service;

import com.first.ecobazaar.entity.CartEntity;
import com.first.ecobazaar.entity.ProductsEntity;
import com.first.ecobazaar.entity.UserEntity;
import com.first.ecobazaar.repository.CartRepo;
import com.first.ecobazaar.repository.ProductsRepo;
import com.first.ecobazaar.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CartService {
    
    @Autowired
    private CartRepo cartRepo;
    
    @Autowired
    private ProductsRepo productsRepo;
    
    @Autowired
    private UserRepo userRepo;
    
    public CartEntity addToCart(Long userId, Long productId, int quantity) {
        try {
            UserEntity user = userRepo.findById(userId).orElse(null);
            if (user == null) {
                throw new RuntimeException("User not found with ID: " + userId);
            }
            
            ProductsEntity product = productsRepo.findById(productId).orElse(null);
            if (product == null) {
                throw new RuntimeException("Product not found with ID: " + productId);
            }
            
            // Check if item already exists in cart
            CartEntity existingItem = cartRepo.findByUserUserIdAndProductProductId(userId, productId);
            
            if (existingItem != null) {
                // Update quantity and subtotal
                existingItem.setQuantity(existingItem.getQuantity() + quantity);
                existingItem.setSubtotal(existingItem.getQuantity() * product.getPrice());
                return cartRepo.save(existingItem);
            } else {
                // Create new cart item
                CartEntity cartItem = new CartEntity();
                cartItem.setUser(user);
                cartItem.setProduct(product);
                cartItem.setQuantity(quantity);
                cartItem.setSubtotal(quantity * product.getPrice());
                return cartRepo.save(cartItem);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error adding to cart: " + e.getMessage());
        }
    }
    
    public List<CartEntity> getCartItems(Long userId) {
        return cartRepo.findByUserUserId(userId);
    }
    
    public CartEntity updateCartItem(Long userId, Long productId, int quantity) {
        CartEntity cartItem = cartRepo.findByUserUserIdAndProductProductId(userId, productId);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartItem.setSubtotal(quantity * cartItem.getProduct().getPrice());
            return cartRepo.save(cartItem);
        }
        throw new RuntimeException("Cart item not found");
    }
    
    public void removeFromCart(Long userId, Long productId) {
        try {
            CartEntity cartItem = cartRepo.findByUserUserIdAndProductProductId(userId, productId);
            if (cartItem != null) {
                cartRepo.delete(cartItem);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error removing from cart: " + e.getMessage());
        }
    }
    
    public void clearCart(Long userId) {
        try {
            List<CartEntity> cartItems = cartRepo.findByUserUserId(userId);
            cartRepo.deleteAll(cartItems);
        } catch (Exception e) {
            throw new RuntimeException("Error clearing cart: " + e.getMessage());
        }
    }
}