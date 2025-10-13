package br.com.guiareze.picpay.persistence.adapter;

import br.com.guiareze.picpay.core.domain.Account;
import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.core.mapper.AccountMapper;
import br.com.guiareze.picpay.core.ports.repository.AccountRepository;
import br.com.guiareze.picpay.persistence.entity.AccountEntity;
import br.com.guiareze.picpay.persistence.repository.AccountJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountJpaRepository repository;

    @Override
    public Account find(Account account) {
        AccountEntity response = repository.findByIdAndUserId(account.getId(), account.getUserId())
                .orElseThrow(() -> new RuntimeException("Account not found")); //  TODO - criar exception customizada
        return AccountMapper.toDomain(response);
    }

    @Override
    public Account save(Account account) {
        AccountEntity entityEntry = AccountMapper.toEntity(account);
        AccountEntity entitySaved = repository.save(entityEntry);
        return AccountMapper.toDomain(entitySaved);
    }
}
