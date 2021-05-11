package com.ds.marketrest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ds.marketrest.model.Item;

public interface ItemRepository extends MongoRepository<Item, Integer> {

    public List<Item> findByItemNameContaining(String name);
    
    public List<Item> findByItemCatagory(String catagory);
}
