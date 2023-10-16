package InventorySystem.persistence.repository;

import InventorySystem.persistence.entity.DeliveryOrder;
import InventorySystem.persistence.projection.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Integer> {
/*    @Query(value = "select\n" +
            "    a.description_delivery_order as DescriptionDeliveryOrder,\n" +
            "    a.delivery_order_id as DeliveryOrderId,\n" +
            "    a.available_service_id as AvailableServiceId,\n" +
            "    a.payment_method_id as PaymentMethodId,\n" +
            "    a.client_id as ClientId,\n" +
            "    a.material_id as MaterialId,\n" +
            "    a.available_service_id as AvailableServiceId\n" +
            "FROM\n" +
            "    delivery_order a\n" +
            "    INNER JOIN client on a.client_id = client.client_id\n" +
            "    INNER JOIN materials on a.material_id = materials.material_id\n" +
            "    INNER JOIN available_service on a.available_service_id = available_service.available_service_id", nativeQuery = true)*/
@Query(value = "select\n" +
        "    a.delivery_order_id as DeliveryOrderId,\n" +
        "\ta.description_delivery_order as DescriptionDeliveryOrder,\n" +
        "    materials.material_name as MaterialName,\n" +
        "    payment_method.payment_method as PaymentMethod,\n" +
        "    CONCAT(client.first_name, ' ', client.last_name) as ClientFullName,\n" +
        "    available_service.service_name as AvailableService,\n" +
        "    available_service.service_cost as AvailableServiceCost\n" +
        "    \n" +
        "FROM\n" +
        "    delivery_order a\n" +
        "    INNER JOIN client on a.client_id = client.client_id\n" +
        "    INNER JOIN materials on a.material_id = materials.material_id\n" +
        "    INNER JOIN available_service on a.available_service_id = available_service.available_service_id\n" +
        "    INNER JOIN payment_method on a.payment_method_id = payment_method.payment_method_id", nativeQuery = true)
    List<OrderSummary> getAllDeliveryOrders();
}