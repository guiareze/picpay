package br.com.guiareze.picpay.persistence.adapter;

import br.com.guiareze.picpay.core.domain.Account;
import br.com.guiareze.picpay.core.mapper.AccountMapper;
import br.com.guiareze.picpay.core.ports.repository.AccountRepository;
import br.com.guiareze.picpay.persistence.entity.AccountEntity;
import br.com.guiareze.picpay.persistence.exception.PersistenceException;
import br.com.guiareze.picpay.persistence.repository.AccountJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountJpaRepository repository;

    @Override
    public Account findById(Long id) {
        Optional<AccountEntity> entityFound;
        try {
            entityFound = repository.findById(id);
        } catch (Exception exception){
            throw new PersistenceException("Error to find account by account id", exception);
        }
        return entityFound.map(AccountMapper::toDomain)
                .orElseThrow(()  -> new PersistenceException("Account not found"));
    }

    @Override
    public Account findByAccountIdAndUserId(Account account) {
        Optional<AccountEntity> entityFound;
        try {
            entityFound = repository.findByIdAndUserId(account.getId(), account.getUserId());
        } catch (Exception exception){
            throw new PersistenceException("Error to find account by account id / user id", exception);
        }
        return entityFound.map(AccountMapper::toDomain)
                .orElseThrow(()  -> new PersistenceException("Account not found"));
    }

    @Override
    public Account save(Account account) {
        AccountEntity entityEntry = AccountMapper.toEntity(account);
        AccountEntity entitySaved;
        try {
            entitySaved = repository.save(entityEntry);
        } catch (Exception exception){
            throw new PersistenceException("Error to save account", exception);
        }
        return AccountMapper.toDomain(entitySaved);
    }
}
