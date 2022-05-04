package aptecht2008m.demospring.product;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private String description;
    private  int status;
     private  double price;

    public Product(String name, String description, int status, double price) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.price = price;
    }
}
