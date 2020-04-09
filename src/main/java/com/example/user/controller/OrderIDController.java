package com.example.user.controller;

import com.example.user.exception.ResourceNotFoundException;

import com.example.user.model.OrderID;
import com.example.user.repository.OrderIDRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3")
@Api(description = "Order ID CRUD", produces = "application/json")
public class OrderIDController {

    @Autowired
    private OrderIDRepository orderIDRepository;

    @GetMapping("/Orderid")
    public List<OrderID> getAllOrdersID() {
        return orderIDRepository.findAll();
    }

    @GetMapping("/Orderid/{id}")
    public ResponseEntity<OrderID> getOrderById(@PathVariable(value = "id") Long orderId)
            throws ResourceNotFoundException {
        OrderID orderID = orderIDRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Costumers not found for this id", " :: "));
        ;
        return ResponseEntity.ok().body(orderID);
    }

    @PostMapping("/Orderid")
    public OrderID createOrderID(@Valid @RequestBody OrderID orderID) {
        return orderIDRepository.save(orderID);
    }

    @PutMapping("/Orderid/{id}")
    public ResponseEntity<OrderID> updateOrderId(@PathVariable(value = "id") Long orderId,
                                                     @Valid @RequestBody OrderID orderIDValid) throws ResourceNotFoundException {
        OrderID orderID = orderIDRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("OrderId not found for this id", " :: " + orderId));
        orderID.setOrderID(orderIDValid.getOrderID());
        orderID.setProductID(orderIDValid.getProductID());
        orderID.setCreatedAt(orderIDValid.getCreatedAt());
        orderID.setUpdatedAt(orderIDValid.getUpdatedAt());

        final OrderID updatedOrderID = orderIDRepository.save(orderID);
        return ResponseEntity.ok(updatedOrderID);
    }

    @DeleteMapping("/Orderid/{id}")
    public Map<String, Boolean> deleteOrderID(@PathVariable(value = "id") Long orderId)
            throws ResourceNotFoundException {
        OrderID orderID = orderIDRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("OrderId not found for this id", ":: " + orderId));

        orderIDRepository.delete(orderID);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        System.out.println("Deleted Berhasil");
        return response;
    }


}
