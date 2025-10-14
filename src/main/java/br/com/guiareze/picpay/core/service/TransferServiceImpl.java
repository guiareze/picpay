package br.com.guiareze.picpay.core.service;

import br.com.guiareze.picpay.core.domain.Account;
import br.com.guiareze.picpay.core.domain.Transfer;
import br.com.guiareze.picpay.core.exception.TransferOperationException;
import br.com.guiareze.picpay.core.ports.core.service.TransferService;
import br.com.guiareze.picpay.core.ports.repository.AccountRepository;
import br.com.guiareze.picpay.core.ports.repository.UserRepository;
import br.com.guiareze.picpay.core.ports.rest.AuthorizationClient;
import br.com.guiareze.picpay.core.ports.rest.NotificationClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AuthorizationClient authorizationClient;
    private final NotificationClient notificationClient;

    @Override
    @Transactional
    public Transfer transfer(Transfer transfer) {
        Account payerAccount = accountRepository.findById(transfer.getPayer());
        payerValidations(payerAccount, transfer);
        Account payeeAccount = accountRepository.findById(transfer.getPayee());

        if (!authorizationClient.isAuthorized()) throw new TransferOperationException("Transfer not authorized");

        payeeAccount.updateAmount(transfer.getValue());
        payerAccount.updateAmount(transfer.getValue().negate());
        accountRepository.save(payeeAccount);
        accountRepository.save(payerAccount);

        CompletableFuture.runAsync(() -> notificationClient.sendNotification(transfer));

        return transfer;
    }

    private void payerValidations(Account payerAccount, Transfer transfer) {
        payerAccount.amountValidation(transfer.getValue());
        userRepository.findById(payerAccount.getUserId()).categoryValidation();
    }
}
