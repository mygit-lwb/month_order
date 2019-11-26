package com.lianweibo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "yk_product_detail")
@Getter
@Setter
public class ProductDetail implements Serializable {
    private static final long serialVersionUID = -8683654950547483418L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName; // 商品名字
    private String productRule; // 规格
    private Integer productNum; // 数量
    private String productAddress;  // 售至
    private String sendAddress;   // 送至
    private Integer aboutDay; // 预计天数
    private Integer reallyDay;  // 实际天数
    private String productExplain;    // 备注
    @ManyToOne
    @JoinColumn(name = "orderId")
    @JsonIgnore
    private Order order;
}
