package br.com.guiareze.picpay.core.domain;

import java.math.BigDecimal;

public class CommonUser extends User{

    public CommonUser(String name, String document, String email, String password) {
        super(name, document, email, password);
    }

    public void transfer(User user, BigDecimal amount){
        user.getAccount().setAmount(user.getAccount().getAmount().add(amount));
    }

}
