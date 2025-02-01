package com.jtsolv.jtsolvcurr.gamedices.repository.entity;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
