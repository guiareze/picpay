package br.com.guiareze.picpay.core.ports.persistence;

import br.com.guiareze.picpay.persistence.entity.UserEntity;

public interface UserPersistence {

    UserEntity createUser(UserEntity userEntity);

}
