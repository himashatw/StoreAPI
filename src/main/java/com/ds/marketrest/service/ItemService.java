package com.ds.marketrest.service;

import java.util.List;
import java.util.Optional;

import com.ds.marketrest.model.Item;

public interface ItemService {
	
	public List<Item> findAll();

	public Optional<Item> findById(int id);

	public Item addItem(Item item);

	public String deleteById(int id);
	
	public Item updateItem(Item item);

}
