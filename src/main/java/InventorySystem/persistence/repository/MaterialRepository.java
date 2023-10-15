package InventorySystem.persistence.repository;

import InventorySystem.persistence.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    @Query(value = "Select * from materials where material_type_id = :material_type_id", nativeQuery = true)
    List<Material> getByMaterialType(@Param("material_type_id")Integer materialTypeId);

    @Query(value = "SELECT * FROM materials WHERE material_name ILIKE %:name%",nativeQuery = true)
    List<Material> FindMaterialByName(String name);
}