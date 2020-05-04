package com.example.accountMgtService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long cusId;
	
	private String customer_name;

	

	public Customer() {
		super();
	}

	public long getCusId() {
		return cusId;
	}

	public void setCusId(long cusId) {
		this.cusId = cusId;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	//@OneToOne(mappedBy = "customer")
	//private Sorder sorder;

	
	
}

