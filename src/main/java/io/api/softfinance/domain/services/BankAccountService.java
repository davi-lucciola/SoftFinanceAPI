package io.api.softfinance.domain.services;

import io.api.softfinance.domain.errors.DomainError;
import io.api.softfinance.domain.errors.NoContentError;
import io.api.softfinance.domain.errors.NotFoundError;
import io.api.softfinance.domain.interfaces.repositories.IBankAccountRepository;
import io.api.softfinance.domain.interfaces.services.IBankAccountService;
import io.api.softfinance.domain.interfaces.services.IBankService;
import io.api.softfinance.domain.models.Bank;
import io.api.softfinance.domain.models.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService implements IBankAccountService {

    @Autowired
    private IBankService bankService;

    @Autowired
    private IBankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccount> findAll() {
        List<BankAccount> accounts = bankAccountRepository.findAll();

        if (accounts.isEmpty())
            throw new NoContentError();

        return accounts;
    }

    @Override
    public BankAccount findById(String uuid) {
        BankAccount bankAccount = bankAccountRepository.findById(uuid);

        if (bankAccount == null) {
            throw new NotFoundError("Conta Bancaria não encontrada.");
        }

        return bankAccount;
    }

    @Override
    public BankAccount create(BankAccount bankAccount) {

        Bank bank = bankService.findById(bankAccount.getBankUuid());

        BankAccount bankAccountInDb = bankAccountRepository
                .findByBankAndAccountNumber(bank.getUuid(), bankAccount.getAccountNumber());

        if (bankAccountInDb != null) {
            throw new DomainError("Há uma conta cadastrada com com esse banco e esse numero de conta.");
        }

        bankAccount.setBank(bank);
        return bankAccountRepository.save(bankAccount);
    }
}
