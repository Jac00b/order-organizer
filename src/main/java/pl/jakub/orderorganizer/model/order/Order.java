package pl.jakub.orderorganizer.model.order;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.jakub.orderorganizer.model.service.Service;
import pl.jakub.orderorganizer.model.cook.Cook;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> products = new ArrayList<>();
    private String address;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "CO_ID")
    private Cook cook;

    @ManyToOne
    @JoinColumn(name = "SV_ID")
    private Service service;
    private LocalDateTime start;
    private LocalDateTime end;


}
