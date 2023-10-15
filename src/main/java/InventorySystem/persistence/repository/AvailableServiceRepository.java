package InventorySystem.persistence.repository;

import InventorySystem.persistence.entity.AvailableService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableServiceRepository extends JpaRepository<AvailableService, Integer> {
}