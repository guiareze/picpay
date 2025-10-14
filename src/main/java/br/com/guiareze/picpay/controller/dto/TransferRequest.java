package br.com.guiareze.picpay.controller.dto;

import java.math.BigDecimal;

public record TransferRequest (
        Long payer,
        Long payee,
        BigDecimal value
){
}
