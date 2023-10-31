package com.springdatajpa.springdatajpa.pojo;

import jakarta.persistence.*;

@Entity
@Table(name="SpringDataJPAUser")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="account_id")       // create a new colum points to pk of Account table
    private Account account;            // no need to separately create entry for Account table
                                        // when create user, we can set account here

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
