package com.jtsolv.jtsolvcurr.gamedices.service.admin;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.OrderProduct;
import org.springframework.validation.annotation.Validated;


@Validated
public interface OrderProductService {

    OrderProduct create(OrderProduct orderProduct);
}
