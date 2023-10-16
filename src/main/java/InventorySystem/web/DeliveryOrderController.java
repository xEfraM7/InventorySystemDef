package InventorySystem.web;

import InventorySystem.persistence.entity.DeliveryOrder;
import InventorySystem.persistence.projection.OrderSummary;
import InventorySystem.service.DeliveryOrderService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/delivery-order")
public class DeliveryOrderController {
    private final DeliveryOrderService deliveryOrderService;
    @Autowired

    public DeliveryOrderController(DeliveryOrderService deliveryOrderService) {
        this.deliveryOrderService = deliveryOrderService;
    }

    @GetMapping("/detailing")
    public List<OrderSummary> getAllOrdersDetailing(){
        return this.deliveryOrderService.getAllOrdersDetailing();
    }

    @GetMapping
    public List<DeliveryOrder> getAllOrders(){
        return this.deliveryOrderService.getAll();
    }

    @PostMapping
    public DeliveryOrder saveNewOrder(@RequestBody DeliveryOrder deliveryOrder){
        return this.deliveryOrderService.saveNewOrder(deliveryOrder);
    }

}
