package com.example.accountMgtService.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountMgtService.dao.OrderItemRepository;
import com.example.accountMgtService.model.OrderItem;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService{
	
	@Autowired
	OrderItemRepository orderItemRepository ;
	
	@Override
    public OrderItem create(OrderItem  orderItem ) {
        return this.orderItemRepository.save(orderItem);
    }


	

}
