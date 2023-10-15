package InventorySystem.persistence.repository;

import InventorySystem.persistence.entity.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Integer> {
}