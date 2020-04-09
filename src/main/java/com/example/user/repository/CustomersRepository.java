package com.example.user.repository;


import java.util.List;

import com.example.user.model.Customers;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {


}

