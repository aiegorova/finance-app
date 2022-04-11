package com.aleenlos.finance.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

}
