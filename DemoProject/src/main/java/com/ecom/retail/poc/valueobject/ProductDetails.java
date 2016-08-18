package com.ecom.retail.poc.valueobject;

import java.io.Serializable;

public class ProductDetails implements Serializable{

	private static final long serialVersionUID = -4651789868021803075L;
	
	private Integer id;
	private String name;
	private ProductPrice current_Price;
	
	public ProductDetails(){
		
	}
	
	public ProductDetails(Integer id, String name, ProductPrice current_Price){
		this.id = id;
		this.name =name;
		this.current_Price = current_Price;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductPrice getCurrent_Price() {
		return current_Price;
	}
	public void setCurrent_Price(ProductPrice current_Price) {
		this.current_Price = current_Price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((current_Price == null) ? 0 : current_Price.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDetails other = (ProductDetails) obj;
		if (current_Price == null) {
			if (other.current_Price != null)
				return false;
		} else if (!current_Price.equals(other.current_Price))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", current_Price=" + current_Price + "]";
	}

}
