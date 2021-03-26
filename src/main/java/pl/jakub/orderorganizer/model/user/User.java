package pl.jakub.orderorganizer.model.user;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.jakub.orderorganizer.model.cook.Cook;
import pl.jakub.orderorganizer.model.service.Service;

import javax.persistence.*;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "US_ID")
    private Long id;

    @Column(name = "US_LOGIN", unique = true, nullable = false)
    private String login;

    @Column(name = "US_PASSWORD", nullable = false)
    private String password;

    @Column(name = "US_ROLE")
    private String role;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "SV_ID")
    private Service serviceId;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "CO_ID")
    private Cook cookId;


}
