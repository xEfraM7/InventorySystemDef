package InventorySystem.persistence.repository;

import InventorySystem.persistence.entity.DeliveryOrder;
import InventorySystem.persistence.projection.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Integer> {
@Query(value = "select\n" +
        "\tdelivery_order_id as DeliveryOrderId,\n" +
        "    payment_method as PaymentMethod,\n" +
        "    CONCAT(first_name, ' ', last_name) as ClientFullName,\n" +
        "    description_delivery_order as DescriptionDeliveryOrder,\n" +
        "    available_service.service_cost as AvailableServiceCost,\n" +
        "    available_service.service_name as AvailableServiceName\n" +
        "from\n" +
        "    delivery_order a\n" +
        "    INNER JOIN payment_method on a.payment_method_id = payment_method.payment_method_id\n" +
        "    INNER JOIN client on a.client_id = client.client_id\n" +
        "    INNER JOIN available_service on a.available_service_id = available_service.available_service_id", nativeQuery = true)
    List<OrderSummary> getAllDeliveryOrders();

}