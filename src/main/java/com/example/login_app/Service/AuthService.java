//package com.example.login_app.Service;
//
//import com.example.login_app.Entity.UserEntity;
//import com.example.login_app.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AuthService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public boolean authenticate(String username, String password) {
//        System.out.println("Authenticating username: " + username); // Log username ที่รับมา
//        Optional<UserEntity> user = userRepository.findByUsername(username);
//
//        if (user.isPresent()) {
//            System.out.println("User found: " + user.get().getUsername()); // Log ข้อมูลผู้ใช้ที่พบ
//            boolean passwordMatch = new BCryptPasswordEncoder().matches(password, user.get().getPassword());
//            System.out.println("Password match: " + passwordMatch); // Log ผลลัพธ์การตรวจสอบรหัสผ่าน
//            return passwordMatch;
//        }
//
//        System.out.println("User not found"); // Log กรณีไม่พบผู้ใช้
//        return false;
//    }
//}
package com.example.login_app.Service;

import com.example.login_app.Entity.UserEntity;
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
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return new BCryptPasswordEncoder().matches(password, user.get().getPassword());
        }
        return false;
    }
}
