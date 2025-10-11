package br.com.guiareze.picpay.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;
    private BigDecimal amount;

    protected void updateAmount(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

}
