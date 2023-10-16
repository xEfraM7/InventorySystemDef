package InventorySystem.persistence.repository;

import InventorySystem.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByfirstNameContainingIgnoreCase(String firstName);
}