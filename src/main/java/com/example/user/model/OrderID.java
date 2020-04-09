package com.example.user.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "OrderID")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
public class OrderID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderID;


    private Long ProductID;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    public Long getOrderID() {
        return OrderID;
    }

    public Long getProductID() {
        return ProductID;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public OrderID setOrderID(Long orderID) {
        OrderID = orderID;
        return this;
    }

    public OrderID setProductID(Long productID) {
        ProductID = productID;
        return this;
    }

    public OrderID setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public OrderID setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }



    @Override
    public String toString() {
        return "OrderID{" +
                "OrderID=" + OrderID +
                ", ProductID=" + ProductID +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
