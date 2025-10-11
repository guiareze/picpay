package br.com.guiareze.picpay.persistence.adapter;

import br.com.guiareze.picpay.core.ports.repository.UsersRepository;
import br.com.guiareze.picpay.persistence.entity.UserEntity;
import br.com.guiareze.picpay.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UsersRepository {

    private final UserJpaRepository repository;

    @Override
    public UserEntity save(UserEntity userEntity) {
        // TODO - add tratamento de exceptions
        return repository.save(userEntity);
    }

}
