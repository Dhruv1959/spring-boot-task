package com.crud.task.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.task.dao.InventoryDAO;
import com.crud.task.dto.InventoryDTO;
import com.crud.task.entity.InventoryEntity;
import com.crud.task.exception.RecordNotFoundException;
import com.crud.task.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryDAO inventoryDAO;

	@Override
	public InventoryDTO createOrUpdateInventory(InventoryDTO inventoryDTO) {
		Long inventoryId = inventoryDTO.getId();
		if (null != inventoryId && !inventoryDAO.findById(inventoryDTO.getId()).isPresent()) {
			throw new RecordNotFoundException("Inventory does not exist");
		}
		InventoryEntity inventoryEntity = new InventoryEntity(inventoryDTO.getProductName(),
				inventoryDTO.getDescription(), inventoryDTO.getCategory(), inventoryDTO.getQuantity(),
				inventoryDTO.getUnitPrice());
		if (null != inventoryId) {
			inventoryEntity.setId(inventoryId);
		}
		inventoryId = inventoryDAO.save(inventoryEntity).getId();
		inventoryDTO.setId(inventoryId);
		return inventoryDTO;
	}

	@Override
	public List<InventoryDTO> getAllInventories() {
		List<InventoryEntity> inventoryEntities = inventoryDAO.findAll();
		return inventoryEntities.stream().map(a -> new InventoryDTO(a.getId(), a.getProductName(), a.getDescription(),
				a.getCategory(), a.getQuantity(), a.getUnitPrice())).toList();
	}

	@Override
	public boolean deleteInventoryById(Long id) {
		try {
			inventoryDAO.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

}
