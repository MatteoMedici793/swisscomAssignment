package com.swisscom.assignment.entity;

import com.swisscom.assignment.utils.ProductType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column
    private String type;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String description;

    @NonNull
    @Column
    private int availability;

}
