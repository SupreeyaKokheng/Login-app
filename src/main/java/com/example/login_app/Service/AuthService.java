package com.example.login_app.Service;

import com.example.login_app.Entity.User;
import com.example.login_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            // ตรวจสอบรหัสผ่าน (ใช้ BCrypt)
            return new BCryptPasswordEncoder().matches(password, user.get().getPassword());
        }
        return false;
    }
}
