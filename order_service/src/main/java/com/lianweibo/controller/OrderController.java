package com.lianweibo.controller;

import com.lianweibo.VO.OrderVO;
import com.lianweibo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;
    // 列表查询
    @RequestMapping("/list")
    public Object selectOrderList(@RequestBody OrderVO orderVO){
        return orderService.selectOrderList(orderVO);
    }

}
