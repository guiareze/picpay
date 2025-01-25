package br.com.guiareze.picpay.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "user_name")
    private String name;

}
