package InventorySystem.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "delivery_order", schema = "public", indexes = {
        @Index(name = "delivery_order_pkey", columnList = "delivery_order_id", unique = true)
})
public class DeliveryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_order_id", nullable = false)
    private Integer deliveryOrderId;

    @Column(name = "description_delivery_order", length = 500)
    private String descriptionDeliveryOrder;

    @Column(name = "payment_method_id")
    private Integer paymentMethodId;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "material_id")
    private Integer materialId;

    @Column(name = "available_service_id")
    private Integer availableServiceId;

}