package io.api.softfinance.domain.interfaces.repositories;

import io.api.softfinance.domain.models.BankAccount;

import java.util.List;

public interface IBankAccountRepository {
    List<BankAccount> findAll();
    BankAccount findById(String uuid);
    BankAccount findByBankAndAccountNumber(String bankUuid, String accountNumber);
    BankAccount save(BankAccount bankAccount);
}
