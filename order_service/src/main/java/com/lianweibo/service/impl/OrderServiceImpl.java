package com.lianweibo.service.impl;

import com.lianweibo.VO.OrderVO;
import com.lianweibo.entity.Order;
import com.lianweibo.repository.OrderRepository;
import com.lianweibo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Object selectOrderList(OrderVO vo) {

        Specification<Order> spec = new Specification<Order>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(!StringUtils.isEmpty(vo.getOrderId())){
                    Predicate p1 = cb.like(root.get("orderId"), "%" + vo.getOrderId() + "%");
                    list.add(p1);
                }
                if(!StringUtils.isEmpty(vo.getBuyerName())){
                    Predicate p2 = cb.like(root.get("buyerName"), "%" + vo.getBuyerName() + "%");
                    list.add(p2);
                }
                if(!StringUtils.isEmpty(vo.getBuyerTel())){
                    Predicate p3 = cb.like(root.get("buyerTel"), "%" + vo.getBuyerTel() + "%");
                    list.add(p3);
                }
                if(!StringUtils.isEmpty(vo.getStartReceive())){
                    Predicate p4 = cb.greaterThanOrEqualTo(root.get("recevice"), vo.getStartReceive());
                    list.add(p4);
                }
                if(!StringUtils.isEmpty(vo.getEndReceive())){
                    Predicate p5 = cb.lessThanOrEqualTo(root.get("recevice"), vo.getEndReceive());
                    list.add(p5);
                }
                if(!StringUtils.isEmpty(vo.getStartSend())){
                    Predicate p4 = cb.greaterThanOrEqualTo(root.get("send"), vo.getStartSend());
                    list.add(p4);
                }
                if(!StringUtils.isEmpty(vo.getEndSend())){
                    Predicate p5 = cb.lessThanOrEqualTo(root.get("send"), vo.getEndSend());
                    list.add(p5);
                }

                return cb.and(list.toArray(new Predicate[list.size()]));
            }
        };

        return orderRepository.findAll(spec, PageRequest.of(vo.getPageNum()-1,vo.getPageSize()));
    }

    @Override
    public void deleteOrder(List<Order> ids) {
        orderRepository.deleteAll(ids);
    }

    @Override
    public void insertOrder(Order order) {
        orderRepository.save(order);
    }
}
