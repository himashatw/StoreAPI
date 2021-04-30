package com.ds.marketrest.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ds.marketrest.model.Item;
import com.ds.marketrest.repository.ItemRepository;
import com.ds.marketrest.service.ItemService;

public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemrepository;

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return itemrepository.findAll();
	}

	@Override
	public Optional<Item> findById(int id) {
		// TODO Auto-generated method stub
		return itemrepository.findById(id);
	}

	@Override
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		itemrepository.save(item);
		return item;
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		itemrepository.deleteById(id);
		return "Item" + id + "deleted successfully";
	}

	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		itemrepository.save(item);
		return item;
	}

}
