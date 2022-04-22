package com.example.appannotationandcascade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankAccount {
    @Id
    @GeneratedValue
    private Integer id;

    private String code;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    private Client client;
}
