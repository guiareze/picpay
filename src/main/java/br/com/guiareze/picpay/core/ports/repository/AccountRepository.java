package br.com.guiareze.picpay.core.ports.repository;

import br.com.guiareze.picpay.core.domain.Account;

public interface AccountRepository {

    Account find(Account account);
    Account save(Account account);

}
