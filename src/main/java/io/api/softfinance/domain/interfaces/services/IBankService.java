package io.api.softfinance.domain.interfaces.services;

import io.api.softfinance.domain.models.Bank;

import java.util.List;

public interface IBankService {
    List<Bank> findAll(String search);
    Bank findById(String uuid);
    Bank create(Bank bank);
    Bank update(Bank bank);
    void delete(String bankUuid);
}
