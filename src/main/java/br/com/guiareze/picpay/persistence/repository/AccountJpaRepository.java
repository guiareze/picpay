package br.com.guiareze.picpay.persistence.repository;

import br.com.guiareze.picpay.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByIdAndUserId(Long accountId, Long userId);

}
