package br.com.guiareze.picpay.persistence.adapter;

import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.core.mapper.UserMapper;
import br.com.guiareze.picpay.core.ports.repository.UserRepository;
import br.com.guiareze.picpay.persistence.entity.UserEntity;
import br.com.guiareze.picpay.persistence.exception.PersistenceException;
import br.com.guiareze.picpay.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository repository;

    @Override
    public User save(User user) {
        log.info("Saving user: {}", user);
        UserEntity entityToSave = UserMapper.toEntity(user);

        UserEntity entitySaved;
        try{
            entitySaved = repository.save(entityToSave);
        } catch (Exception exception) {
            throw new PersistenceException("Error to save user", exception);
        }

        return UserMapper.toDomain(entitySaved);
    }

    @Override
    public User findById(Long id) {
        log.info("Finding user by id: {}", id);

        Optional<UserEntity> entity;
        try {
            entity = repository.findById(id);
        } catch (Exception exception) {
            throw new PersistenceException("Error to find user by id", exception);
        }

        return entity.map(UserMapper::toDomain)
                .orElseThrow(() -> new PersistenceException("User not found"));
    }


}
