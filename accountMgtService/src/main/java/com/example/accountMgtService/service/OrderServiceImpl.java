package com.example.accountMgtService.service;

import java.time.LocalDate;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountMgtService.dao.OrderRepository;

import com.example.accountMgtService.model.Sorder;

@Service
@Transactional 
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	OrderRepository orderRepository ;

	@Override
	public Iterable<Sorder> getAllOrders() {
		return orderRepository.findAll();


	}

	
	
	@Override
    public Sorder create(Sorder  sorder ) {
        sorder.setDateCreated(LocalDate.now());

        return this.orderRepository.save(sorder);
    }

    @Override
    public void update(Sorder  sorder) {
        this.orderRepository.save(sorder);
    }

	
	
	

}
