package pl.jakub.orderorganizer.services;

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
}
