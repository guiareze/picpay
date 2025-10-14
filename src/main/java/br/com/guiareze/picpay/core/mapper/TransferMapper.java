package br.com.guiareze.picpay.core.mapper;

import br.com.guiareze.picpay.controller.dto.TransferRequest;
import br.com.guiareze.picpay.core.domain.Transfer;

public class TransferMapper {

    public static Transfer toDomain(TransferRequest request) {
        return new Transfer(
                request.payer(),
                request.payee(),
                request.value()
        );
    }

}
