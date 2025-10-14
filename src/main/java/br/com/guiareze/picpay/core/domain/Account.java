package br.com.guiareze.picpay.core.domain;

import br.com.guiareze.picpay.core.exception.AccountValidationException;
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
    private Long userId;
    private BigDecimal amount;

    public void updateAmount(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

    public void amountValidation(BigDecimal amount) {
        if (this.amount.compareTo(amount) < 0) {
            throw new AccountValidationException("Account %s hasn't sufficient balance to transfer %s".formatted(this.id, amount) );
        }
    }

}
