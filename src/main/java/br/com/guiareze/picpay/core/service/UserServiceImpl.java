package br.com.guiareze.picpay.core.service;

import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.core.mapper.UserMapper;
import br.com.guiareze.picpay.core.ports.core.service.UserService;
import br.com.guiareze.picpay.core.ports.repository.UsersRepository;
import br.com.guiareze.picpay.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Override
    public User createUser(User user) {
        UserEntity entityToSave = UserMapper.toEntity(user);
        UserEntity savedEntity = usersRepository.save(entityToSave);
        // TODO - Efetuar a criação da conta associada ao usuário
        return UserMapper.toDomain(savedEntity);
    }

}
