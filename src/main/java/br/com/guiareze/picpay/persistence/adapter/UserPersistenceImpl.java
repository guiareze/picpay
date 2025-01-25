package br.com.guiareze.picpay.persistence.adapter;

import br.com.guiareze.picpay.core.ports.persistence.UserPersistence;
import br.com.guiareze.picpay.persistence.entity.UserEntity;
import br.com.guiareze.picpay.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPersistenceImpl implements UserPersistence {

    private final UserRepository repository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return repository.save(userEntity);
    }

}
