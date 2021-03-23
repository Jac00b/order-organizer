package pl.jakub.orderorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakub.orderorganizer.model.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
