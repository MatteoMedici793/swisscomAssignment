package com.swisscom.assignment.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderPK.class)
public class Orders {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column
    private String state;

    @Id
    @NonNull
    @Column
    private Long product_id;

    @NonNull
    @Column
    private int quantity;

    @NonNull
    @Column
    private Date order_creation;

    @Column
    private Date order_deletion;

    @Column
    private Date order_delivery;

}
