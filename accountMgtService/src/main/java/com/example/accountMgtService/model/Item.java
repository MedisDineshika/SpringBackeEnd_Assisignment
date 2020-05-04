package com.example.accountMgtService.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Item {



	//private long itemId;
	
	//private String product_name;

	
	//private long  price;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    //@NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;
 
    private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
 
   
	

	//@ManyToOne
	//@JsonIgnore
	//@JoinColumn(name = "orderid")
	//private Sorder sorder ;

	
	
	
	
}
