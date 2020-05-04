package com.example.accountMgtService.service;

import com.example.accountMgtService.model.Item;

public interface ItemService {

	Iterable<Item> getAllItems();

	Item getItem(long id);

	Item save(Item item);
	

	
	

}
