package br.com.guiareze.picpay.core.service;

import br.com.guiareze.picpay.core.domain.Account;
import br.com.guiareze.picpay.core.ports.core.service.AccountService;
import br.com.guiareze.picpay.core.ports.core.service.UserService;
import br.com.guiareze.picpay.core.ports.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final UserService userService;

    @Override
    public Account create(Account account) {
        return repository.save(account);
    }

    @Override
    public Account deposit(Account account) {
        Account existingAccount = repository.findByAccountIdAndUserId(account);
        existingAccount.updateAmount(account.getAmount());
        return repository.save(existingAccount);
    }

}
