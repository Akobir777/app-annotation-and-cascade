package com.example.appannotationandcascade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Person person;

    public Address(String street, String city, Person person) {
        this.street = street;
        this.city = city;
        this.person = person;
    }
}
