package InventorySystem.persistence.projection;

import InventorySystem.persistence.repository.DeliveryOrderRepository;

import java.math.BigDecimal;

public interface OrderSummary{
    Integer getDeliveryOrderId();
    String getDescriptionDeliveryOrder();
    String getPaymentMethod();
    String getClientFullName();
    String getAvailableServiceName();
    BigDecimal getAvailableServiceCost();
}
