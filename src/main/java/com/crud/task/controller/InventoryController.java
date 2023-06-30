package com.crud.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.task.dto.InventoryDTO;
import com.crud.task.exception.RecordNotFoundException;
import com.crud.task.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/create-update-inventory")
	public ResponseEntity<InventoryDTO> createOrUpdateInventory(@RequestBody InventoryDTO inventoryDTO) {
		return ResponseEntity.ok().body(inventoryService.createOrUpdateInventory(inventoryDTO));
	}

	@GetMapping("/get-all-inventories")
	public ResponseEntity<List<InventoryDTO>> getAllInventories() {
		List<InventoryDTO> inventoryDTO = inventoryService.getAllInventories();
		if (inventoryDTO.isEmpty()) {
			throw new RecordNotFoundException("Data not found");
		}
		return ResponseEntity.ok().body(inventoryDTO);
	}

	@DeleteMapping("/delete-by-id/{id}")
	public ResponseEntity<String> deleteInventoryById(@PathVariable Long id) {
		boolean deleted = inventoryService.deleteInventoryById(id);
		if (deleted) {
			return new ResponseEntity<>("Inventory item deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to delete inventory item", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
