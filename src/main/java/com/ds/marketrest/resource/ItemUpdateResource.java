package com.ds.marketrest.resource;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//to avoid updating all fields of the domain and user can update fields for choice
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ItemUpdateResource {

	private String itemName;
	private int qty;
	private double itemPrice;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

}
