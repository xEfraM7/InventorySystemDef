package InventorySystem.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "materials", schema = "public", indexes = {
        @Index(name = "materials_pkey", columnList = "material_id", unique = true)
})
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id", nullable = false)
    private Integer materialId;

    @Column(name = "material_name", nullable = false, length = 100)
    private String materialName;

    @Column(name = "material_cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal materialCost;

    @Column(name = "description_materials", length = 500)
    private String descriptionMaterials;

    @Column(name = "material_type_id")
    private Integer materialTypeId;

    @Override
    public String toString() {
        return "Material{" +
                "materialId=" + materialId +
                ", materialName='" + materialName + '\'' +
                ", materialCost=" + materialCost +
                ", descriptionMaterials='" + descriptionMaterials + '\'' +
                '}';
    }
}