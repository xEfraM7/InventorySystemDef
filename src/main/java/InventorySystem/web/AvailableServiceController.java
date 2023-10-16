package InventorySystem.web;
import InventorySystem.persistence.entity.AvailableService;
import InventorySystem.service.AvailableServiceOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/add-available-service")
    public ResponseEntity<AvailableService> addAvailableService(@RequestBody AvailableService availableService){
        if (availableService.getAvailableServiceId() == null || !this.availableServiceOnService.existAvailableService(availableService.getAvailableServiceId())){
            return ResponseEntity.ok(this.availableServiceOnService.addAvailableService(availableService));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/edit-available-service")
    public ResponseEntity<AvailableService> editAvailableService(@RequestBody AvailableService availableService){
        if (availableService.getAvailableServiceId() != null  && this.availableServiceOnService.existAvailableService(availableService.getAvailableServiceId())){
            return ResponseEntity.ok(this.availableServiceOnService.addAvailableService(availableService));
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/delete-available-service/{availableServiceId}")
    public ResponseEntity<AvailableService> deleteAvailableService(@PathVariable Integer availableServiceId){
        if (this.availableServiceOnService.existAvailableService(availableServiceId)){
            this.availableServiceOnService.deleteAvailableService(availableServiceId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }





}