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

    public boolean existClient(int clientId){
        return this.clientRepository.existsById(clientId);
    }

    public List<Client>getAllClients(){
        return this.clientRepository.findAll();
    }

    public List<Client>getAllClientsByFirstName(String firstName){
        return this.clientRepository.findAllByfirstNameContainingIgnoreCase(firstName);
    }

    public Client addClient(Client client){
        return this.clientRepository.save(client);
    }

    public void deleteClient(Integer clientId){
        this.clientRepository.deleteById(clientId);
    }

}
