package br.com.guiareze.picpay.core.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfer {

    private Long payer;
    private Long payee;
    private BigDecimal value;

}
