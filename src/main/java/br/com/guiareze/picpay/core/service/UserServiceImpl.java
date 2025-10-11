package br.com.guiareze.picpay.core.service;

import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.core.mapper.UserMapper;
import br.com.guiareze.picpay.core.ports.core.service.UserService;
import br.com.guiareze.picpay.core.ports.repository.UsersRepository;
import br.com.guiareze.picpay.persistence.entity.AccountEntity;
import br.com.guiareze.picpay.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Override
    public User createUser(User user) {
        // Crie o UserEntity a partir do domínio
        UserEntity entityToSave = UserMapper.toEntity(user);

        // Crie a conta e associe o usuário
        AccountEntity account = new AccountEntity();
        account.setAmount(BigDecimal.ZERO);
        account.setUser(entityToSave);

        // Associe a conta ao usuário
        entityToSave.setAccount(account);

        // Salve o usuário (e a conta, por cascade)
        UserEntity savedEntity = usersRepository.save(entityToSave);
        // TODO - Efetuar a criação da conta associada ao usuário
        return UserMapper.toDomain(savedEntity);
    }

}
