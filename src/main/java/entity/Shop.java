package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "shop_name")
    private String shopName;
    @ManyToMany
    @JoinTable(name = "shop_products",
    joinColumns = @JoinColumn(name = "shop_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> shopProducts;

}
