package br.com.guiareze.picpay.core.service;

import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.core.ports.core.service.UserService;
import br.com.guiareze.picpay.core.ports.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

}
