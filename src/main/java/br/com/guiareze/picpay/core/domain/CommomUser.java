package br.com.guiareze.picpay.core.domain;

import br.com.guiareze.picpay.controller.enumeration.Category;

import java.math.BigDecimal;

public class CommomUser extends User{

    public CommomUser(Long id, String name, String document, String email, String password, Category category, Account account) {
        super(id, name, document, email, password, category, account);
    }

    @Override
    public void transfer(User receiver, BigDecimal value) {
        if (this.getAccount().getAmount().compareTo(value) >= 0) {
            this.getAccount().updateAmount(value.negate());
            receiver.getAccount().updateAmount(value);
        } else {
            throw new IllegalArgumentException("Transfer error - Insufficient funds");
        }
    }

}
