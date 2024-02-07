package com.hridoykrisna.Lazeez.model;

import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CartItem extends BaseModel {
    private int food_id;
    private String name;
    private String description;
    private float unit_price;
    private int quantity;
    private float total_price;
    private String imagePath;
    private int status;
}
