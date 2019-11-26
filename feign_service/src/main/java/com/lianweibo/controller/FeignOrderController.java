package com.lianweibo.controller;

import com.lianweibo.VO.OrderVO;
import com.lianweibo.feignService.FeignOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feignOrder")
public class FeignOrderController {
    @Autowired
    private FeignOrderService feignOrderService;

    @RequestMapping("/list")
    public Object selectOrderList(@RequestBody OrderVO orderVO){
        return feignOrderService.selectOrderList(orderVO);
    }

}
