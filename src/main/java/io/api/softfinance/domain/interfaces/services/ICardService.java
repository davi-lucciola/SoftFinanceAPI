package io.api.softfinance.domain.interfaces.services;

import io.api.softfinance.domain.errors.DomainError;
import io.api.softfinance.domain.models.Card;

import java.util.List;

public interface ICardService {
    List<Card> findAll();
    Card findById(String uuid);
    Card create(Card card) throws DomainError;
    void delete(String uuid) throws DomainError;
}
