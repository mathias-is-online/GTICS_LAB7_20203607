package com.example.lab720203607.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LocationID")
    private Integer LocationID;

    private String City;
    private String Country;

}
