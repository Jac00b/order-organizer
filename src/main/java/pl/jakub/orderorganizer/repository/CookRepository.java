package pl.jakub.orderorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.orderorganizer.model.cook.Cook;

@Repository
public interface CookRepository extends JpaRepository<Cook, Long> {
}
