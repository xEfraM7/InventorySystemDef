package InventorySystem.service;

import InventorySystem.persistence.entity.AvailableService;
import InventorySystem.persistence.repository.AvailableServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableServiceOnService {
    private final AvailableServiceRepository availableServiceRepository;

    public AvailableServiceOnService(AvailableServiceRepository availableServiceRepository) {
        this.availableServiceRepository = availableServiceRepository;
    }

    public List<AvailableService> getAllAvailableServices(){
        return this.availableServiceRepository.findAll();
    }

    public boolean existAvailableService(int availableServiceId){
        return this.availableServiceRepository.existsById(availableServiceId);
    }

    public AvailableService addAvailableService(AvailableService availableService){
        return this.availableServiceRepository.save(availableService);
    }

    public void deleteAvailableService(Integer availableServiceId){
        this.availableServiceRepository.deleteById(availableServiceId);
    }

}
