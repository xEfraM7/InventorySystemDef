package InventorySystem.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

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

    @NotNull
    @NotBlank(message = "target incompleto")
    @Column(name = "material_name", nullable = false, length = 100)
    private String materialName;

    @NotNull
    @DecimalMin("0,1")
    @Column(name = "material_cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal materialCost;

    @NotNull
    @NotBlank
    @Column(name = "description_materials", length = 500)
    private String descriptionMaterials;

    @NotNull
    @NotBlank
    @Column(name = "material_type_id")
    private Integer materialTypeId;

    @NotNull
    @NotBlank
    @Column(name = "available_service_id")
    private Integer availableServiceId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "available_service_id",referencedColumnName = "available_service_id",insertable = false,updatable = false)
    private AvailableService availableService;

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