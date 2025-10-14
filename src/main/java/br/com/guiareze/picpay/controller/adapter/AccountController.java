package br.com.guiareze.picpay.controller.adapter;

import br.com.guiareze.picpay.controller.dto.AccountCreationRequest;
import br.com.guiareze.picpay.controller.dto.AccountCreationResponse;
import br.com.guiareze.picpay.controller.dto.AccountDepositRequest;
import br.com.guiareze.picpay.controller.dto.AccountDepositResponse;
import br.com.guiareze.picpay.core.domain.Account;
import br.com.guiareze.picpay.core.mapper.AccountMapper;
import br.com.guiareze.picpay.core.ports.core.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public ResponseEntity<AccountCreationResponse> create(@RequestBody AccountCreationRequest request) {
        log.info("Received account creation request: {}", request);
        Account account = AccountMapper.toDomain(request);
        Account responseService = service.create(account);
        AccountCreationResponse response = AccountMapper.toAccountCreationResponse(responseService);
        log.info("Account created successfully: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<AccountDepositResponse> deposit(@PathVariable Long accountId, @RequestBody AccountDepositRequest request) {
        log.info("Received deposit request for accountId: {}, request: {}", accountId, request);
        Account account = AccountMapper.toDomain(accountId, request);
        Account responseService = service.deposit(account);
        AccountDepositResponse response = AccountMapper.toAccountDepositResponse(responseService);
        log.info("Deposit completed for accountId: {}, response: {}", accountId, response);
        return ResponseEntity.ok(response);
    }

}
