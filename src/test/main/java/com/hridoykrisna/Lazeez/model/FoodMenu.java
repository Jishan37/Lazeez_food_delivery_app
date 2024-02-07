package com.hridoykrisna.Lazeez.model;

import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class FoodMenu extends BaseModel {

    private String name;
    private String description;
    private float price;
    private int total_order;
    private String imagePath;
    private int status;

}
