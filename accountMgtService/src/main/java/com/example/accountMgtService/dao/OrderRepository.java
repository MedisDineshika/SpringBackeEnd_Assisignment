package com.example.accountMgtService.dao;

import org.springframework.data.repository.CrudRepository;


import com.example.accountMgtService.model.Sorder;


public interface OrderRepository extends  CrudRepository<Sorder, Long> {

}
