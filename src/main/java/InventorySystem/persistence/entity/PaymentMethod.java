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
@Table(name = "payment_method", schema = "public", indexes = {
        @Index(name = "payment_method_pkey", columnList = "payment_method_id", unique = true)
})
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id", nullable = false)
    private Integer paymentMethodId;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @OneToMany(mappedBy = "paymentMethod",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DeliveryOrder> deliveryOrders;

}