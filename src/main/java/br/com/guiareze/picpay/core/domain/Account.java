package br.com.guiareze.picpay.core.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Account {

    private UUID id;

    private BigDecimal amount;

    public Account(BigDecimal amount){
        this.id = UUID.randomUUID();
        this.amount = amount;
    }

}
