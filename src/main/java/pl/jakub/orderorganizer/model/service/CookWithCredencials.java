package pl.jakub.orderorganizer.model.service;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CookWithCredencials {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;

}
