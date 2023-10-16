package InventorySystem.web;

import InventorySystem.persistence.entity.Client;
import InventorySystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(this.clientService.getAllClients());
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<List<Client>>getClientsByName(@PathVariable String firstName){
        return ResponseEntity.ok(this.clientService.getAllClientsByFirstName(firstName));
    }

    @PostMapping("/add-client")
    public ResponseEntity<Client>addClient(@RequestBody Client client){
        if(client.getClientId() == null || !this.clientService.existClient(client.getClientId())){
            return ResponseEntity.ok(this.clientService.addClient(client));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit-client")
    public ResponseEntity<Client>editClient(@RequestBody Client client){
        if(client.getClientId() != null && this.clientService.existClient(client.getClientId())){
            return ResponseEntity.ok(this.clientService.addClient(client));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete-client/{clientId}")
    public ResponseEntity<Client> deleteMaterial(@PathVariable Integer clientId){
        if (this.clientService.existClient(clientId)){
            this.clientService.deleteClient(clientId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
