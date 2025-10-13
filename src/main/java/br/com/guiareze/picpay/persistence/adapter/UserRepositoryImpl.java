package br.com.guiareze.picpay.persistence.adapter;

import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.core.mapper.UserMapper;
import br.com.guiareze.picpay.core.ports.repository.UserRepository;
import br.com.guiareze.picpay.persistence.entity.UserEntity;
import br.com.guiareze.picpay.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository repository;

    @Override
    public User save(User user) {
        // TODO - add tratamento de exceptions
        UserEntity entityToSave = UserMapper.toEntity(user);
        UserEntity entitySaved = repository.save(entityToSave);
        return UserMapper.toDomain(entitySaved);
    }

    @Override
    public User findById(Long id) {
        UserEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")); // TODO - criar exception customizada
        return UserMapper.toDomain(entity);
    }


}
