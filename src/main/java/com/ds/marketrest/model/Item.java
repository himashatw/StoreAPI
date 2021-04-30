package com.ds.marketrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Items")
public class Item {
	@Id
	private int itemId;
	private String itemName;
	private int qty;
	private double itemPrice;

	public Item(int itemId, String itemName, int qty, double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.qty = qty;
		this.itemPrice = itemPrice;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

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

	@Override
	public String toString() {
		return "Seller [itemId=" + itemId + ", itemName=" + itemName + ", qty=" + qty + ", itemPrice=" + itemPrice
				+ "]";
	}

}
