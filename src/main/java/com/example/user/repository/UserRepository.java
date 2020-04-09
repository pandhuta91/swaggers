package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user.model.User;

/**
 * Pandhuta Bangkit S 09/04/2020
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
