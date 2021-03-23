package pl.jakub.orderorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakub.orderorganizer.model.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
