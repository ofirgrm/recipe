package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    private String description;
    private BigDecimal amount;

    public Ingredient(String description, double amount, UnitOfMeasure uom) {
        this.description = description;
        this.uom = uom;
        this.amount = new BigDecimal(amount);
    }

}
