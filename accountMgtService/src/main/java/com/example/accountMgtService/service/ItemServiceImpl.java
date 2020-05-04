package com.example.accountMgtService.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountMgtService.dao.ItemRepository;
import com.example.accountMgtService.exception.ResourceNotFoundException;
import com.example.accountMgtService.model.Item;

@Service
@Transactional 
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository itemRepository ;
	@Override
	public Iterable<Item> getAllItems() {
		return itemRepository.findAll();
	}
	
	@Override
    public Item getItem(long id) {
        return itemRepository 
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
    }

	@Override
    public Item save(Item item ) {
        return itemRepository.save(item);
    }

}
