package com.ds.marketrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ds.marketrest.model.Item;
import com.ds.marketrest.service.ItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping("/add")
	public Item addItem(@RequestBody Item item) {
		Item itemObj = itemService.addItem(item);
		return itemObj;
	}

	@GetMapping("/all")
	public ResponseEntity<Object> getAllItems() {
		List<Item> items = itemService.findAll();
		if (!items.isEmpty()) {
			return new ResponseEntity<>(items, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

}
