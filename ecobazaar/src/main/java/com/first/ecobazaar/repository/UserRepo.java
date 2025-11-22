
package com.first.ecobazaar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.first.ecobazaar.entity.*;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity save(UserEntity user);

    List<UserEntity> findAll();
}
