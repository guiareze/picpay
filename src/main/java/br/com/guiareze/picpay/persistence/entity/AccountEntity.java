package br.com.guiareze.picpay.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Data
public class AccountEntity {

    @Id
    @Column(name = "account_id")
    private String id;

    @Column
    private BigDecimal amout;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

}
