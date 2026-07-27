package com.sadguru.library_Management.service.impl;

import com.sadguru.library_Management.dto.request.UserRequest;
import com.sadguru.library_Management.dto.response.UserResponse;
import com.sadguru.library_Management.entity.User;
import com.sadguru.library_Management.exception.ResourceNotFoundException;
import com.sadguru.library_Management.repository.UserRepository;
import com.sadguru.library_Management.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserResponse addUser(UserRequest request) {
         User user = User.builder()
                 .userName(request.getUserName())
                 .email(request.getEmail())
                 .fullName(request.getFullName())
                 .password(request.getPassword())
                 .created_at(LocalDateTime.now())
                 .build();
         User savedUser = repository.save(user);
         return mapToResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAllUser() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No book found with this id: "+ id));

        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());

        User updatedUser = repository.save(user);
        return mapToResponse(updatedUser);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No book found with this id: "+ id));
        return mapToResponse(user);
    }

    @Override
    public void delete(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No book found with this id: "+ id));
        repository.delete(user);

    }

    public UserResponse mapToResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getUserName())
                .fullName(user.getFullName())
                .created_at(user.getCreated_at())
                .build();
    }
}
