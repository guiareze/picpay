package br.com.guiareze.picpay.core.ports.core.service;

import br.com.guiareze.picpay.core.domain.Account;

public interface AccountService {

    Account create(Account account);
    Account deposit(Account account);

}
