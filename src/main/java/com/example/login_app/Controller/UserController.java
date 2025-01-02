//package com.example.login_app.Controller;
//
//import com.example.login_app.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/test")
//    public String testDatabase() {
//        long count = userRepository.count(); // นับจำนวนผู้ใช้ในฐานข้อมูล
//        return "Total users: " + count;
//    }
//}
