package pl.jakub.orderorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakub.orderorganizer.model.cook.Cook;

public interface CookRepository extends JpaRepository<Cook, Long> {
}
