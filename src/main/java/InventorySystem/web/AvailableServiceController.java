package InventorySystem.web;
import InventorySystem.persistence.entity.AvailableService;
import InventorySystem.service.AvailableServiceOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/available-services")
public class AvailableServiceController {
    private final AvailableServiceOnService availableServiceOnService;

    @Autowired
    public AvailableServiceController(AvailableServiceOnService availableServiceOnService) {
        this.availableServiceOnService = availableServiceOnService;
    }

    @GetMapping
    public ResponseEntity<List<AvailableService>> getAllClients(){
        return ResponseEntity.ok(this.availableServiceOnService.getAllAvailableServices());
    }

}