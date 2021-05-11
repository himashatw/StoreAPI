package com.ds.marketrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.marketrest.model.Item;
import com.ds.marketrest.resource.ItemUpdateResource;
import com.ds.marketrest.service.ItemService;

@RestController
@RequestMapping(value = "api/item")
@CrossOrigin(origins = "*") // this annotation used connect different port numbers
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping(value = "/add")
	public ResponseEntity<Item> addItem(@RequestBody Item item) {
		try {
			Item itemAdded = itemService.addItem(item);
			return new ResponseEntity<>(itemAdded, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/all")
	public ResponseEntity<Object> getAllItems() {
		try {
			List<Item> items = itemService.findAll();
			if (!items.isEmpty()) {
				return new ResponseEntity<>(items, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getItemById(@PathVariable(value = "id", required = true) int id) {
		try {
			Optional<Item> item = itemService.findById(id);
			if (item != null) {
				return new ResponseEntity<>(item, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteById(@PathVariable(value = "id", required = true) int id) {
		String mesg = itemService.deleteById(id);
		return mesg;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable(value = "id", required = true) int id,
			@RequestBody ItemUpdateResource itemUpdateResource) {
		try {

			Item itemUpdated = itemService.updateItem(id, itemUpdateResource);
			return new ResponseEntity<>(itemUpdated, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/search/{name}")
	public ResponseEntity<Object> findByItemName(@PathVariable(value = "name", required = true) String name) {
		try {
			List<Item> item = itemService.findByName(name);
			if (item != null) {
				return new ResponseEntity<>(item, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/category/{catagory}")
	public ResponseEntity<Object> findByItemCatagory(@PathVariable(value = "catagory", required = true) String catagory) {
		try {
			List<Item> item = itemService.findByCatagory(catagory);
			if (item != null) {
				return new ResponseEntity<>(item, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
