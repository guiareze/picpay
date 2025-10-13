package br.com.guiareze.picpay.controller.dto;

import java.math.BigDecimal;

public record AccountCreationRequest(
        Long userId,
        BigDecimal amount
) {
}
