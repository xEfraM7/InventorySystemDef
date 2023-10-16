package InventorySystem.service;

import InventorySystem.persistence.entity.DeliveryOrder;
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

    public List<OrderSummary> getAllOrdersDetailing(){
        return this.deliveryOrderRepository.getAllDeliveryOrders();
    }

    public List<DeliveryOrder> getAll(){
        return this.deliveryOrderRepository.findAll();
    }

    public DeliveryOrder saveNewOrder(DeliveryOrder deliveryOrder){
        return this.deliveryOrderRepository.save(deliveryOrder);
    }
}
