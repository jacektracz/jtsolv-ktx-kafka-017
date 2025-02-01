package com.jtsolv.jtsolvcurr.gamedices.repository.entity;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.OrderProduct;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.OrderProductPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
}
