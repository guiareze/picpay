package br.com.guiareze.picpay.persistence.repository;

import br.com.guiareze.picpay.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
