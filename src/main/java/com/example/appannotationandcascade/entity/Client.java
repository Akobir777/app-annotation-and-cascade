package com.example.appannotationandcascade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue
    private Integer id;

    private String fullName;

    private String phoneNumber;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(mappedBy = "client")
    private BankAccount bankAccount;

    public void setBankAccount(BankAccount bankAccount) {
        bankAccount.setClient(this);
        this.bankAccount = bankAccount;
    }
}
