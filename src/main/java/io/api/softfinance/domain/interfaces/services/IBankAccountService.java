package io.api.softfinance.domain.interfaces.services;

import io.api.softfinance.domain.models.BankAccount;

import java.util.List;

public interface IBankAccountService {
    List<BankAccount> findAll();
    BankAccount findById(String uuid);
    BankAccount create(BankAccount bankAccount);
}
