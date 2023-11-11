package io.api.softfinance.infra.converters;

import io.api.softfinance.domain.models.Bank;
import io.api.softfinance.infra.entities.BankEntity;

public class BankConverter {
    public static Bank convert(BankEntity entity) {
        if (entity == null) return null;
        return new Bank(entity.getUuid(), entity.getName());
    }
    public static BankEntity convert(Bank domain) {
        if (domain == null) return null;
        return new BankEntity(domain.getUuid(), domain.getName());
    }
}
