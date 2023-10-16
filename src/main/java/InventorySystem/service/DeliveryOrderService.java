package InventorySystem.service;

import InventorySystem.persistence.projection.OrderSummary;
import InventorySystem.persistence.repository.DeliveryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryOrderService {
    private final DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    public DeliveryOrderService(DeliveryOrderRepository deliveryOrderRepository) {
        this.deliveryOrderRepository = deliveryOrderRepository;
    }

    public List<OrderSummary> getAllOrders(){
        return this.deliveryOrderRepository.getAllDeliveryOrders();
    }
}
