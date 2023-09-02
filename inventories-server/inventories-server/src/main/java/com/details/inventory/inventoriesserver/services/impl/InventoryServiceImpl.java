package com.details.inventory.inventoriesserver.services.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.details.inventory.inventoriesserver.entities.Inventory;
import com.details.inventory.inventoriesserver.repositories.InventoryRepository;
import com.details.inventory.inventoriesserver.services.InventoryService;

public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public Inventory createInventory(Inventory inventory) {
		return (inventoryRepository.save(inventory));
	}

	@Override
	public ResponseEntity<String> deleteInventory(String inventoryid) {
		return new ResponseEntity<String>("Inventory with inventoryid->"+inventoryid +" "+ "deleted successfully.",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Inventory> getInventory(@PathVariable String inventoryid) {
		
		Inventory inventory = inventoryRepository.findById(inventoryid).get();		
		
		return new ResponseEntity<>(inventory,HttpStatus.OK);
	}	

}
