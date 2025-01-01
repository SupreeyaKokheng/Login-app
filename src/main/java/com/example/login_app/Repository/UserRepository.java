package com.example.login_app.Repository;
import com.example.login_app.Entity.UserEntity;  // Import User จากแพ็กเกจที่คุณสร้าง
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
