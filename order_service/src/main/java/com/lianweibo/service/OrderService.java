package com.lianweibo.service;

import com.lianweibo.VO.OrderVO;
import com.lianweibo.entity.Order;

import java.util.List;

public interface OrderService {

    Object selectOrderList(OrderVO orderVO);

    void deleteOrder(List<Order> ids);

    void insertOrder(Order order);


}
