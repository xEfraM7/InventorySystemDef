package InventorySystem.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "material_type", schema = "public", indexes = {
        @Index(name = "material_type_pkey", columnList = "material_type_id", unique = true)
})
public class MaterialType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_type_id", nullable = false)
    private Integer materialTypeId;

    @Column(name = "material_type")
    private String material_type;

}