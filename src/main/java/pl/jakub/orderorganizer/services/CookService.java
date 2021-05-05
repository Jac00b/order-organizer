package pl.jakub.orderorganizer.services;

import org.springframework.stereotype.Service;
import pl.jakub.orderorganizer.dto.CookDto;
import pl.jakub.orderorganizer.model.cook.Cook;
import pl.jakub.orderorganizer.model.mapper.CookMapper;
import pl.jakub.orderorganizer.repository.CookRepository;

@Service
public class CookService {
    private CookMapper cookMapper;
    private CookRepository cookRepository;

    public CookService(CookMapper cookMapper, CookRepository cookRepository) {
        this.cookMapper = cookMapper;
        this.cookRepository = cookRepository;
    }


    public Long createCook(CookDto cookDto){
        Cook cook = cookMapper.mapToEntity(cookDto);
        return cookRepository.save(cook).getId();
    }
}
