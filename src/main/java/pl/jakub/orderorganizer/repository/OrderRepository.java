package pl.jakub.orderorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.orderorganizer.model.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
