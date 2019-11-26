package com.lianweibo.VO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OrderVO {
    private Integer pageNum;
    private Integer pageSize;

    private Integer orderId;
    private String buyerName;
    private String buyerTel;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startReceive;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endReceive;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startSend;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endSend;
}
