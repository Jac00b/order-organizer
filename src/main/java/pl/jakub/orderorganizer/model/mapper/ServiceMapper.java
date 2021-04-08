package pl.jakub.orderorganizer.model.mapper;

import pl.jakub.orderorganizer.dto.ServiceDto;
import pl.jakub.orderorganizer.model.service.Service;

public class ServiceMapper {


    public Service mapToEntity(ServiceDto serviceDto){
        return new Service(null,
                serviceDto.getFirstName(),
                serviceDto.getLastName(),
                null);
    }

    public ServiceDto mapToApi(Service service){
        return new ServiceDto(service.getId(),
                service.getFirstName(),
                service.getLastName());
    }


}
