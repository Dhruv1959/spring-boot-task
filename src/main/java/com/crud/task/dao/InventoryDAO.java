package com.crud.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.task.entity.InventoryEntity;

@Repository
public interface InventoryDAO extends JpaRepository<InventoryEntity, Long> {

}
