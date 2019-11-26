package com.lianweibo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "yk_order")
@Getter
@Setter
public class Order implements Serializable {
    private static final long serialVersionUID = -8655373184406933355L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String buyerName;
    private String buyerTel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date receive;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date send;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private List<ProductDetail> productDetailList;
}
