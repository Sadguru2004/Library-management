package com.sadguru.library_Management.repository;

import com.sadguru.library_Management.dto.request.UserRequest;
import com.sadguru.library_Management.dto.response.UserResponse;
import com.sadguru.library_Management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String email);
}
