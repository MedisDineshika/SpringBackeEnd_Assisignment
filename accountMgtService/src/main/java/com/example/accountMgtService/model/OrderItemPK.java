package com.example.accountMgtService.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "sorder")
public class OrderItemPK implements Serializable {

    private static final long serialVersionUID = 476151177562655457L;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Sorder sorder;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

 

    
	public Sorder getSorder() {
		return sorder;
	}

	public void setSorder(Sorder sorder) {
		this.sorder = sorder;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((sorder.getId() == null)
          ? 0
          : sorder
            .getId()
            .hashCode());
        result = prime * result + ((sorder.getId() == null)
          ? 0
          : item
            .getId()
            .hashCode());

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
        OrderItemPK other = (OrderItemPK) obj;
        if (sorder == null) {
            if (other.sorder != null) {
                return false;
            }
        } else if (!sorder.equals(other.sorder)) {
            return false;
        }

        if (item == null) {
            if (other.item != null) {
                return false;
            }
        } else if (!item.equals(other.item)) {
            return false;
        }

        return true;
    }

	

	
}