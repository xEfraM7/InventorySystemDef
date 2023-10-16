package InventorySystem.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "available_service_id")
    private Integer availableServiceId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "payment_method_id",referencedColumnName = "payment_method_id",insertable = false,updatable = false)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id",referencedColumnName = "client_id",insertable = false,updatable = false)
    private Client client;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "available_service_id",referencedColumnName = "available_service_id",insertable = false,updatable = false)
    private AvailableService availableService;


}