package com.example.accountMgtService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SorderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	
	
	private long itemId ;
	
	private long quantity ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	
	
	
	
}
