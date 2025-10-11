package br.com.guiareze.picpay.core.domain;

import br.com.guiareze.picpay.controller.enumeration.Category;

import java.math.BigDecimal;

public class Logist extends User{

    public Logist(Long id, String name, String document, String email, String password, Category category, Account account) {
        super(id, name, document, email, password, category, account);
    }

    @Override
    public void transfer(User receiver, BigDecimal value) {
        throw new IllegalArgumentException("Logist users cannot make transfers");
    }

}
