package com.example.accountMgtService.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.accountMgtService.model.Item;

public interface ItemRepository  extends CrudRepository<Item, Long>{

}
