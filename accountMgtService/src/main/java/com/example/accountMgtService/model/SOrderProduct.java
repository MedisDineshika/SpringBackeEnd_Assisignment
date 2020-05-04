package com.example.accountMgtService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SOrderProduct {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long OrderProductId;
	
	
	private long OrderId;
	
	private long id ;
	
	private long quantity ;

	public long getOrderProductId() {
		return OrderProductId;
	}

	public void setOrderProductId(long orderProductId) {
		OrderProductId = orderProductId;
	}

	public long getOrderId() {
		return OrderId;
	}

	public void setOrderId(long orderId) {
		OrderId = orderId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	

	
	

}
