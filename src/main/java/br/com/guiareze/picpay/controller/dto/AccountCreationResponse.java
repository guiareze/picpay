package br.com.guiareze.picpay.controller.dto;

import java.math.BigDecimal;

public record AccountCreationResponse(
        Long id,
        Long userId,
        BigDecimal amount
) {
}
