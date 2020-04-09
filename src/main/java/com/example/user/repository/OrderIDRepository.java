package com.example.user.repository;


import com.example.user.model.OrderID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderIDRepository extends JpaRepository<OrderID, Long> {
}
