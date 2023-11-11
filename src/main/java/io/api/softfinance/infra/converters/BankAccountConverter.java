package io.api.softfinance.infra.converters;

import io.api.softfinance.domain.models.BankAccount;
import io.api.softfinance.infra.entities.BankAccountEntity;

public class BankAccountConverter {
    public static BankAccount convert(BankAccountEntity entity) {
        if (entity == null) return null;

        BankAccount domain = new BankAccount();

        domain.setUuid(entity.getUuid());
        domain.setHolder(entity.getHolder());
        domain.setAccountNumber(entity.getAccountNumber());
        domain.setAgency(entity.getAgency());
        domain.setBalance(entity.getBalance());
        domain.setBank(BankConverter.convert(entity.getBank()));

        return domain;
    }

    public static BankAccountEntity convert(BankAccount domain) {
        if (domain == null) return null;

        BankAccountEntity entity = new BankAccountEntity();

        entity.setUuid(domain.getUuid());
        entity.setHolder(domain.getHolder());
        entity.setAccountNumber(domain.getAccountNumber());
        entity.setAgency(domain.getAgency());
        entity.setBalance(domain.getBalance());
        entity.setBank(BankConverter.convert(domain.getBank()));

        return entity;
    }
}
