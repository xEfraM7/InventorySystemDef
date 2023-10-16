package InventorySystem.web;

import InventorySystem.persistence.projection.OrderSummary;
import InventorySystem.service.DeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/delivery-order")
public class DeliveryOrderController {
    private final DeliveryOrderService deliveryOrderService;
    @Autowired
    public DeliveryOrderController(DeliveryOrderService deliveryOrderService) {
        this.deliveryOrderService = deliveryOrderService;
    }

    @GetMapping
    public List<OrderSummary> getAllOrders(){
        return this.deliveryOrderService.getAllOrders();
    }

}
