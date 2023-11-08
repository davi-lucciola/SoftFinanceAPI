package io.api.softfinance.domain.interfaces.services;

import io.api.softfinance.domain.exceptions.DomainException;
import io.api.softfinance.domain.models.Card;

import java.util.List;

public interface ICardService {
    List<Card> findAll();
    Card findById(String uuid);
    Card create(Card card) throws DomainException;
    void delete(String uuid) throws DomainException;
}
