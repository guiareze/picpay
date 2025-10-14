package br.com.guiareze.picpay.core.service;

import br.com.guiareze.picpay.core.domain.Account;
import br.com.guiareze.picpay.core.domain.Transfer;
import br.com.guiareze.picpay.core.ports.core.service.TransferService;
import br.com.guiareze.picpay.core.ports.repository.AccountRepository;
import br.com.guiareze.picpay.core.ports.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Transfer transfer(Transfer transfer) {
        Account payerAccount = accountRepository.findById(transfer.getPayer());
        Account payeeAccount = accountRepository.findById(transfer.getPayee());
        payerValidations(payerAccount, transfer);
        payeeAccount.updateAmount(transfer.getValue());
        payerAccount.updateAmount(transfer.getValue().negate());
        accountRepository.save(payeeAccount);
        accountRepository.save(payerAccount);
        return transfer;
    }

    private void payerValidations(Account payerAccount, Transfer transfer) {
        payerAccount.amountValidation(transfer.getValue());
        userRepository.findById(payerAccount.getUserId()).categoryValidation();
    }
}
