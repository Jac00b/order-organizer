package pl.jakub.orderorganizer.services;

import org.springframework.security.acls.model.NotFoundException;
import pl.jakub.orderorganizer.dto.ServiceDto;
import pl.jakub.orderorganizer.model.mapper.ServiceMapper;
import pl.jakub.orderorganizer.model.service.Service;
import pl.jakub.orderorganizer.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService {
    private ServiceMapper serviceMapper;
    private ServiceRepository serviceRepository;

    public ServiceService(ServiceMapper serviceMapper, ServiceRepository serviceRepository) {
        this.serviceMapper = serviceMapper;
        this.serviceRepository = serviceRepository;
    }

    public Long createService(ServiceDto serviceDto){
        Service service = serviceMapper.mapToEntity(serviceDto);
        return serviceRepository.save(service).getId();
    }

    public ServiceDto getById(Long id){
        return serviceRepository.findById(id)
                .map(e -> serviceMapper.mapToApi(e))
                .orElseThrow(()-> new NotFoundException("Nie znaleziono pracownika z serwisu"));
    }
}
