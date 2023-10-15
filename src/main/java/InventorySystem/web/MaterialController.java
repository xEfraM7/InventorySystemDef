package InventorySystem.web;


import InventorySystem.persistence.entity.Material;
import InventorySystem.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/materials")
public class MaterialController {
    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    //ACTIONS WITH GET METHODS
    @GetMapping
    public ResponseEntity<List<Material>> getAll(){
        return ResponseEntity.ok(this.materialService.getAllMaterials());
    }

    @GetMapping("/type/{materialTypeId}")
    public ResponseEntity<List<Material>> getAllMechanicType(@PathVariable Integer materialTypeId){
        return ResponseEntity.ok(this.materialService.getByMaterialType(materialTypeId));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Material>> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.materialService.getMaterialByName(name));
    }

    //ACTIONS WITH POST METHODS
    @PostMapping("/add-material")
    public ResponseEntity<Material> addMaterial(@RequestBody Material material){
        if (material.getMaterialId() == null || !this.materialService.existMaterial(material.getMaterialId())) {
            return ResponseEntity.ok(this.materialService.addMaterial(material));
        }
        return ResponseEntity.badRequest().build();
    }
    //ACTIONS WITH PUT METHOD
    @PutMapping("/edit-material")
    public ResponseEntity<Material> updateMaterial(@RequestBody Material material){
        if (material.getMaterialId() != null || this.materialService.existMaterial(material.getMaterialId())) {
            return ResponseEntity.ok(this.materialService.addMaterial(material));
        }
        return ResponseEntity.badRequest().build();
    }

    //ACTIONS WITH DELETE METHOD
    @DeleteMapping("/delete-material/{materialId}")
    public ResponseEntity<Material> deleteMaterial(@PathVariable Integer materialId){
        if (this.materialService.existMaterial(materialId)){
            this.materialService.deleteMaterial(materialId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
