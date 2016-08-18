package com.ecom.retail.poc.valueobject;

import java.io.Serializable;

public class ProductPrice implements Serializable{


	private static final long serialVersionUID = 7169345504853295356L;
	private Double value;
	private String currency_Code;
	
	public ProductPrice(){
		
	}
	
	public ProductPrice(Double value,String currency_Code){
		this.value = value;
		this.currency_Code =currency_Code;
		
	}
	
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getcurrency_Code() {
		return currency_Code;
	}
	public void setcurrency_Code(String currency_Code) {
		this.currency_Code = currency_Code;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currency_Code == null) ? 0 : currency_Code.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		ProductPrice other = (ProductPrice) obj;
		if (currency_Code == null) {
			if (other.currency_Code != null)
				return false;
		} else if (!currency_Code.equals(other.currency_Code))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "ProductPrice [value=" + value + ", currency_Code=" + currency_Code + "]";
	}
}
