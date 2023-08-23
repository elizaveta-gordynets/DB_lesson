package entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_name")
    private String productName;
    @ManyToMany(mappedBy = "shopProducts")
    private List<Shop> shopList;

}
