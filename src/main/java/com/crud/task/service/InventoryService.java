package com.crud.task.service;

import java.util.List;

import com.crud.task.dto.InventoryDTO;

public interface InventoryService {

	InventoryDTO createOrUpdateInventory(InventoryDTO inventoryDTO);

	List<InventoryDTO> getAllInventories();

	boolean deleteInventoryById(Long id);

}
