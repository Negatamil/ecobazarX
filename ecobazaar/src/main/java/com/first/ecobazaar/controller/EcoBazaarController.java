package com.first.ecobazaar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EcoBazaarController {
    
    @GetMapping("/health")
    public String healthCheck() {
        return "EcoBazaarX Backend is running successfully!";
    }
    
    @GetMapping("/info")
    public String getAppInfo() {
        return "EcoBazaarX - Carbon Footprint Aware Shopping Assistant Backend";
    }
}