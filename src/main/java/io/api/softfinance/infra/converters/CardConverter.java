package io.api.softfinance.infra.converters;


import io.api.softfinance.domain.models.BankAccount;
import io.api.softfinance.domain.models.Card;
import io.api.softfinance.infra.entities.CardEntity;


public class CardConverter {
    public static Card convert(CardEntity entity) {
        if (entity == null) return null;

        Card domain = new Card();

        domain.setUuid(entity.getUuid());
        domain.setNumber(entity.getNumber());
        domain.setPrintedName(entity.getPrintedName());
        domain.setDueDate(entity.getDueDate());
        domain.setCvv(entity.getCvv());
        domain.setTotalLimit(entity.getTotalLimit());
        domain.setLimitUsed(entity.getLimitUsed());
        domain.setBankAccount(BankAccountConverter.convert(entity.getBankAccount()));

        return domain;
    }

    public static CardEntity convert(Card domain) {
        if (domain == null) return null;

        CardEntity entity = new CardEntity();

        entity.setUuid(domain.getUuid());
        entity.setNumber(domain.getNumber());
        entity.setPrintedName(domain.getPrintedName());
        entity.setDueDate(domain.getDueDate());
        entity.setCvv(domain.getCvv());
        entity.setTotalLimit(domain.getTotalLimit());
        entity.setLimitUsed(domain.getLimitUsed());
        entity.setBankAccount(BankAccountConverter.convert(domain.getBankAccount()));

        return entity;
    }
}
