package br.com.guiareze.picpay.core.ports.repository;

import br.com.guiareze.picpay.persistence.entity.UserEntity;

public interface UsersRepository {

    UserEntity save(UserEntity userEntity);

}
