package com.lianweibo.feignService;

import com.lianweibo.VO.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "order-service")
public interface FeignOrderService {

    @RequestMapping("/order/list")
    Object selectOrderList(@RequestBody OrderVO orderVO);
}
