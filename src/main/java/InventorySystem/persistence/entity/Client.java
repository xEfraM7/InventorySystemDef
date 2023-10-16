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
@Table(name = "client", schema = "public", indexes = {
        @Index(name = "client_pkey", columnList = "client_id", unique = true)
})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "id_card")
    private Integer idCard;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "cellphone", length = 50)
    private String cellphone;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DeliveryOrder> deliveryOrders;

}