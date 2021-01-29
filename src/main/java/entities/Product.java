package entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable {

    private Integer id;
    private String name;
    private Double price;
    private Short quantityInStock;
    private String description;
    private LocalDate createdAt;
    private Integer categoryId;

    public Product() {
        this.createdAt = LocalDate.now();
    }
}
