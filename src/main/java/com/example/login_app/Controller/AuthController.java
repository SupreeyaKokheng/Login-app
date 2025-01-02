package com.example.login_app.Controller;

import com.example.login_app.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000") // อนุญาตให้ React เชื่อมต่อ
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        boolean isAuthenticated = authService.authenticate(username, password);
        if (isAuthenticated) {
            return ResponseEntity.ok(Map.of("message", "Login successful", "status", true));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid username or password", "status", false));
        }
    }
}
