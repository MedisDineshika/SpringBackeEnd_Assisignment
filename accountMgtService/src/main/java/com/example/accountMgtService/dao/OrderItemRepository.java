package com.example.accountMgtService.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.accountMgtService.model.OrderItem;
import com.example.accountMgtService.model.OrderItemPK;

public interface OrderItemRepository extends  CrudRepository<OrderItem, OrderItemPK>{

}
