package br.com.guiareze.picpay.core.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class User {

    private UUID id;

    private String name;

    private String document;

    private String email;

    private String password;

    private Account account;

    public User(String name, String document, String email, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.account = new Account(BigDecimal.ZERO);
    }
}
