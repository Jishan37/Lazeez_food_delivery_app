package com.hridoykrisna.Lazeez.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "order_table")
public class Order extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private int user_id;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "food_order")
    @JoinColumn(name = "order_id", referencedColumnName = "food_menu_list_id")
    private List<FoodMenu> foodMenuList; // Initialize to avoid null issues
    private int quantity;
    private float total_price;
    private int status;
    private Date date;
    private int payment_status;
}
