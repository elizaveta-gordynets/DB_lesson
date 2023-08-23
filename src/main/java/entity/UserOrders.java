package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user_orders")
@EqualsAndHashCode
public class UserOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_name")
    private String orderName;
    @OneToMany
    private List<Product> products;
    @ManyToOne
    private User user;


}
