package com.first.ecobazaar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class TestController {
    
    @GetMapping("/test-auth")
    public String testAuth(@RequestHeader Map<String, String> headers) {
        System.out.println("Headers received:");
        headers.forEach((key, value) -> System.out.println(key + ": " + value));
        
        if (headers.containsKey("authorization")) {
            return "Authorization header found: " + headers.get("authorization");
        } else {
            return "No Authorization header found";
        }
    }
    
    @GetMapping("/test-protected")
    public String testProtected() {
        return "This is a protected endpoint that works!";
    }
}