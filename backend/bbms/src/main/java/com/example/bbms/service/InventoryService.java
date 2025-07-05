package com.example.bbms.service;

import com.example.bbms.entity.Inventory;
import com.example.bbms.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + id));
    }

    @Transactional
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Transactional
    public Inventory updateInventory(Long id, Inventory inventory) {
        Inventory existingInventory = getInventoryById(id);
        
        existingInventory.setBloodType(inventory.getBloodType());
        existingInventory.setQuantity(inventory.getQuantity());
        existingInventory.setLocation(inventory.getLocation());
        existingInventory.setExpirationDate(inventory.getExpirationDate());
        existingInventory.setStatus(inventory.getStatus());
        existingInventory.setDonor(inventory.getDonor());
        
        return inventoryRepository.save(existingInventory);
    }

    @Transactional
    public void deleteInventory(Long id) {
        if (!inventoryRepository.existsById(id)) {
            throw new RuntimeException("Inventory not found with id: " + id);
        }
        inventoryRepository.deleteById(id);
    }

    public List<Inventory> getAvailableInventory() {
        return inventoryRepository.findByStatus("Available");
    }
} 