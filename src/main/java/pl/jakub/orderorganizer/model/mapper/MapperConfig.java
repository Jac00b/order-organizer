package pl.jakub.orderorganizer.model.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {



    @Bean
    ServiceMapper serviceMapper(){
        return new ServiceMapper();
    }

    @Bean
    CookMapper cookMapper(){return new CookMapper();}
}
