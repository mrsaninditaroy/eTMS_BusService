package com.details.inventory.inventoriesserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.details.inventory.inventoriesserver.entities.*;
 
public interface InventoryRepository 
	extends JpaRepository<Inventory,String> {

}
