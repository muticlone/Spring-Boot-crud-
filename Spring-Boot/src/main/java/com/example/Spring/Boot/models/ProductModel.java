package com.example.Spring.Boot.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS")

public class ProductModel  implements Serializable {
    private  static  final  long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID IdProduct ;
    private  String name;
    private BigDecimal value;

    public UUID getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(UUID idProduct) {
        IdProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
