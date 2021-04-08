package pl.jakub.orderorganizer.dto;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDto {

    private Long id;
    private String firstName;
    private String lastName;

}
