package com.details.inventory.inventoriesserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.details.inventory.inventoriesserver.entities.Inventory;
import com.details.inventory.inventoriesserver.services.InventoryService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("createInventory")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {

		Inventory savedInventory = inventoryService.createInventory(inventory);

		return new ResponseEntity<Inventory>(savedInventory, HttpStatus.CREATED);
	}	
	
	@DeleteMapping("/inventories/{inventoryid}/deleteInventory")
	public ResponseEntity<String> deleteInventory(@PathVariable("bookingid") String inventoryid) {
		
		return  new ResponseEntity<String>("Inventory with inventoryid->"+inventoryid +" "+ "deleted successfully.",HttpStatus.OK);
	
	}
	
	

}
