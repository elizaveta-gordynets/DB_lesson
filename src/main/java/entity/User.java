package entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@EqualsAndHashCode
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    @Column(name = "ordered_sum")
    private int orderedSum;
    private String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserOrders> order;
    @OneToOne
    private Role role;

}
