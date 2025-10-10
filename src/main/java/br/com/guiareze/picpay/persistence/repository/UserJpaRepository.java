package br.com.guiareze.picpay.persistence.repository;

import br.com.guiareze.picpay.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
