package com.jtsolv.jtsolvcurr.gamedices.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy") 
    private LocalDate dateCreated;

    private String status;

    private List<OrderProductDTO> orderProducts = new ArrayList<>();

    
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderProductDTO> orderProducts = getOrderProducts();
        return sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderProductDTO> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductDTO> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }
    
}
