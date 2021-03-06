package com.example.accountMgtService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class OrderItem {
	 @EmbeddedId
	    @JsonIgnore
	    private OrderItemPK pk;

	    @Column(nullable = false) private Integer quantity;

	    public OrderItem() {
	        super();
	    }

	    public OrderItem(Sorder sorder, Item item, Integer quantity) {
	    	pk = new OrderItemPK();
	        pk.setSorder(sorder);
	        pk.setItem(item);
	        this.quantity = quantity;
	    }

	    @Transient
	    public Item getItem() {
	        return this.pk.getItem();
	    }

	    @Transient
	    public Double getTotalPrice() {
	        return getItem().getPrice() * getQuantity();
	    }

	    public OrderItemPK getPk() {
	        return pk;
	    }

	    public void setPk(OrderItemPK pk) {
	        this.pk = pk;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        OrderItem other = (OrderItem) obj;
	        if (pk == null) {
	            if (other.pk != null) {
	                return false;
	            }
	        } else if (!pk.equals(other.pk)) {
	            return false;
	        }

	        return true;
	    }
	
}
