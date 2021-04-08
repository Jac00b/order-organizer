package pl.jakub.orderorganizer.model.mapper;

import pl.jakub.orderorganizer.dto.CookDto;
import pl.jakub.orderorganizer.dto.ServiceDto;
import pl.jakub.orderorganizer.model.cook.Cook;

public class CookMapper {

    public Cook mapToEntity(CookDto cookDto){
        return new Cook(null,
                cookDto.getFirstName(),
                cookDto.getLastName(),
                null);
    }

    public CookDto mapToApi(Cook cook){
        return new CookDto(cook.getId(),
                cook.getFirstName(),
                cook.getLastName());
    }
}
