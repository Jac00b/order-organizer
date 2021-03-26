package pl.jakub.orderorganizer.dto;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.jakub.orderorganizer.model.user.UserRole;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private UserRole role;
    private Long serviceId;
    private Long cookId;
}
