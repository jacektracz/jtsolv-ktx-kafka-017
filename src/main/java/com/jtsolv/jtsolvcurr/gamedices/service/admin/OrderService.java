package com.jtsolv.jtsolvcurr.gamedices.service.admin;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.Order;
import org.springframework.validation.annotation.Validated;


@Validated
public interface OrderService {

    Iterable<Order> getAllOrders();

    Order create( Order order);

    void update( Order order);
}
