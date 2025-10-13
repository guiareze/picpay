package br.com.guiareze.picpay.controller.dto;

import java.math.BigDecimal;

public record AccountDepositRequest(
        Long userId,
        BigDecimal amount
) {
}
