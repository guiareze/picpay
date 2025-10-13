package br.com.guiareze.picpay.core.ports.repository;

import br.com.guiareze.picpay.core.domain.User;

public interface UserRepository {

    User save(User user);
    User findById(Long id);

}
