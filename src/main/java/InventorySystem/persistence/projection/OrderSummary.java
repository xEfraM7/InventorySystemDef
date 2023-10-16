package InventorySystem.persistence.projection;

import java.math.BigDecimal;

public interface OrderSummary {
    Integer getDeliveryOrderId();
    String getDescriptionDeliveryOrder();
    String getPaymentMethod();
    String getClientFullName();
    String getAvailableService();
    BigDecimal getAvailableServiceCost();
    String getMaterialName();
}
