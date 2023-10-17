package InventorySystem.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
@Table(name = "available_service", schema = "public", indexes = {
        @Index(name = "available_service_pkey", columnList = "available_service_id", unique = true)
})
public class AvailableService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_service_id", nullable = false)
    private Integer availableServiceId;


    @Column(name = "service_name", length = 50)
    private String serviceName;

    @Column(name = "service_cost", precision = 10, scale = 2)
    private BigDecimal serviceCost;

    @OneToMany(mappedBy = "availableService",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DeliveryOrder> deliveryOrders;

    @OneToMany(mappedBy = "availableService",fetch = FetchType.EAGER)
    private List<Material> materials;

}