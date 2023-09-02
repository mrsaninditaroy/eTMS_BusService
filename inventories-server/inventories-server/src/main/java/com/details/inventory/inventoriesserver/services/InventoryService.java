package com.details.inventory.inventoriesserver.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.details.inventory.inventoriesserver.entities.*;

public interface InventoryService {
	
    public Inventory createInventory(Inventory inventory);		
	
	public ResponseEntity<String> deleteInventory(@PathVariable String inventoryid);
	
	public ResponseEntity<Inventory> getInventory(@PathVariable String inventoryid);
		

}
