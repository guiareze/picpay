package br.com.guiareze.picpay.core.service;

import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.core.mapper.UserMapper;
import br.com.guiareze.picpay.core.ports.core.UserService;
import br.com.guiareze.picpay.core.ports.persistence.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserPersistence persistence;

    @Override
    public User createUser(User user) {
        persistence.createUser(UserMapper.INSTANCE.toUserEntity(user));
        return user;
    }

}
