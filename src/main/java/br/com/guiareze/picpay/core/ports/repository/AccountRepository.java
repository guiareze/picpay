package br.com.guiareze.picpay.core.ports.repository;

import br.com.guiareze.picpay.core.domain.Account;

public interface AccountRepository {

    Account findById(Long id);
    Account findByAccountIdAndUserId(Account account);
    Account save(Account account);

}
