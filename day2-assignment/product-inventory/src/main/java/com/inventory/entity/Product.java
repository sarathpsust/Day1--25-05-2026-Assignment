package com.inventory.entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    private String category;
}
