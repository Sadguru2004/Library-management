package com.sadguru.library_Management.controller;


import com.sadguru.library_Management.dto.request.LoginRequest;
import com.sadguru.library_Management.dto.request.UserRequest;
import com.sadguru.library_Management.dto.response.ApiResponse;
import com.sadguru.library_Management.dto.response.UserResponse;
import com.sadguru.library_Management.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @PostMapping("/register")
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserRequest request){
        return ResponseEntity.ok(service.addUser(request));
    }

    @GetMapping("user")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUser());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PutMapping("/user")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,@Valid @RequestBody UserRequest request){
        return ResponseEntity.ok(service.updateUser(id,request));
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginRequest request) {
        return service.login(request);
    }
}
