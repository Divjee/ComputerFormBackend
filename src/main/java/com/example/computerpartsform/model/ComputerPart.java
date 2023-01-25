package com.example.computerpartsform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "computer_parts")
public class ComputerPart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computer_part_seq")
    @SequenceGenerator(name = "computer_part_seq", sequenceName = "computer_part_seq", allocationSize = 1)
    private Long id;
    @NotBlank
    private String type;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotNull
    private BigDecimal price;

    public ComputerPart(String type, String brand, String model, BigDecimal price) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }


}
