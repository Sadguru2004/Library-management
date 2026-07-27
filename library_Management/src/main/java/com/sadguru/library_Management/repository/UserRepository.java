package com.sadguru.library_Management.repository;

import com.sadguru.library_Management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
