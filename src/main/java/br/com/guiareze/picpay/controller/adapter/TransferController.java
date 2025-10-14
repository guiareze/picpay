package br.com.guiareze.picpay.controller.adapter;

import br.com.guiareze.picpay.controller.dto.TransferRequest;
import br.com.guiareze.picpay.core.domain.Transfer;
import br.com.guiareze.picpay.core.mapper.TransferMapper;
import br.com.guiareze.picpay.core.ports.core.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<Void> transfer(@RequestBody TransferRequest request) {
        log.info("Transfer requested: {}", request);
        Transfer transferRequested = TransferMapper.toDomain(request);
        Transfer transferResult = transferService.transfer(transferRequested);
        log.info("Transfer successful: {}", transferResult);
        return ResponseEntity.noContent().build();
    }

}
