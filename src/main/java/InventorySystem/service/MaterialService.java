package InventorySystem.service;

import InventorySystem.persistence.entity.Material;
import InventorySystem.persistence.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(@Lazy MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

public boolean existMaterial(int materialId){
        return this.materialRepository.existsById(materialId);
}

    //ACTIONS WITH GET METHODS
    public List<Material> getAllMaterials(){
        return this.materialRepository.findAll();
    }

    public List<Material> getByMaterialType(Integer materialTypeId){
        return this.materialRepository.getByMaterialType(materialTypeId);
    }

    public List<Material> getMaterialByName(String name){
        return this.materialRepository.FindMaterialByName(name);
    }

    //ACTIONS WITH POST METHODS
    public Material addMaterial(Material material){
        return this.materialRepository.save(material);
    }

    //ACTIONS WITH DELETE METHODS

    public void deleteMaterial(Integer materialId){
        this.materialRepository.deleteById(materialId);
    }

}
