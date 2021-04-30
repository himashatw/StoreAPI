package com.ds.marketrest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ds.marketrest.model.Item;

public interface ItemRepository extends MongoRepository<Item, Integer>{

}
