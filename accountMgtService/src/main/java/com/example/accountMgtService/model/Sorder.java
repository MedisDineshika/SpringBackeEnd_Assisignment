package com.example.accountMgtService.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Sorder {

	
	//private long orderId;
	
	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name = "cus_id")
	//private Customer customer;
	
	
	//@OneToMany(mappedBy = "sorder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private List<Item> items;
	
	
	//private long No ;

	
	//private long total;
	
	//private long cusId;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;
 
    private String status;
    
    
 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@JsonManagedReference
    @OneToMany(mappedBy = "pk.sorder")
    @Valid
    private List<OrderItem> orderItems = new ArrayList<>();
 
    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderItem> orderItems = getOrderItems();
        for (OrderItem op : orderItems) {
            sum += op.getTotalPrice();
        }
        return sum;
    }
 
    @Transient
    public int getNumberOfItems() {
        return this.orderItems.size();
    }

	
	
	
	
	
	
	



}
