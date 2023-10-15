package InventorySystem.service;

import InventorySystem.persistence.entity.Client;
import InventorySystem.persistence.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client>getAllClients(){
        return this.clientRepository.findAll();
    }

}
