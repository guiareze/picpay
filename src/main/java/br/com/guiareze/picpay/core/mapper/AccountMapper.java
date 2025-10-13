package br.com.guiareze.picpay.core.mapper;

import br.com.guiareze.picpay.controller.dto.AccountCreationRequest;
import br.com.guiareze.picpay.controller.dto.AccountCreationResponse;
import br.com.guiareze.picpay.controller.dto.AccountDepositRequest;
import br.com.guiareze.picpay.controller.dto.AccountDepositResponse;
import br.com.guiareze.picpay.core.domain.Account;
import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.persistence.entity.AccountEntity;
import br.com.guiareze.picpay.persistence.entity.UserEntity;

public class AccountMapper {

    public static Account toDomain(Long accountId, AccountDepositRequest request){
        return new Account(
                accountId,
                request.userId(),
                request.amount()
        );
    }

    public static Account toDomain(AccountEntity entity){
        return new Account(
                entity.getId(),
                entity.getUser().getId(),
                entity.getAmount()
        );
    }

    public static Account toDomain(AccountCreationRequest request){
        return new Account(
                null,
                request.userId(),
                request.amount()
        );
    }

    public static AccountCreationResponse toAccountCreationResponse(Account account){
        return new AccountCreationResponse(
                account.getId(),
                account.getUserId(),
                account.getAmount()
        );
    }

    public static AccountDepositResponse toAccountDepositResponse(Account account){
        return new AccountDepositResponse(
                account.getId(),
                account.getUserId(),
                account.getAmount()
        );
    }

    public static AccountEntity toEntity(Account account){
        AccountEntity entity = new AccountEntity();
        entity.setId(account.getId());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(account.getUserId());
        entity.setUser(userEntity);

        entity.setAmount(account.getAmount());
        return entity;
    }

}
