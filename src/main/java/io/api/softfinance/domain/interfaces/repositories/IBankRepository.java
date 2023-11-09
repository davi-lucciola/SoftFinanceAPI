package io.api.softfinance.domain.interfaces.repositories;

import io.api.softfinance.domain.models.Bank;

import java.util.List;

public interface IBankRepository {
    List<Bank> findAll(String search);
    Bank findById(String uuid);
    Bank findByName(String name);
    Bank save(Bank bank);
    void deleteById(String uuid);
}
