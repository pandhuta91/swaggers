package com.example.user.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.user.exception.ResourceNotFoundException;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

/**
 * Pandhuta Bangkit S 09/04/2020
 */
@RestController
@RequestMapping("/api/v1")
@Api(description = "User CRUD")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id", "::"));
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,
                           @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id ", "::"));

        user.setFname(userDetails.getFname());
        user.setLname(userDetails.getLname());
        user.setAddress(userDetails.getAddress());
        user.setCity(userDetails.getCity());
        user.setCountry(userDetails.getCountry());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id", "::"));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
