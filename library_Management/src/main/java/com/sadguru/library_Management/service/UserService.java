package com.sadguru.library_Management.service;

import com.sadguru.library_Management.dto.request.BookRequest;
import com.sadguru.library_Management.dto.request.LoginRequest;
import com.sadguru.library_Management.dto.request.UserRequest;
import com.sadguru.library_Management.dto.response.ApiResponse;
import com.sadguru.library_Management.dto.response.BookResponse;
import com.sadguru.library_Management.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse addUser(UserRequest request);

    List<UserResponse> getAllUser();

    UserResponse updateUser(Long id,UserRequest request);

    UserResponse getUserById(Long id);

    void delete(Long id);

    public ApiResponse login(LoginRequest request);
}
