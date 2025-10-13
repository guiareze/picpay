package br.com.guiareze.picpay.controller.dto;

import java.math.BigDecimal;

public record AccountDepositResponse(
        Long id,
        Long userId,
        BigDecimal amount
) {
}
