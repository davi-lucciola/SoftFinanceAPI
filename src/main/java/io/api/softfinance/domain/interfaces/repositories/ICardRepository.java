package io.api.softfinance.domain.interfaces.repositories;

import io.api.softfinance.domain.models.Card;

import java.util.List;

public interface ICardRepository {
    List<Card> findAll();
    Card findById(String uuid);
    Card findByNumber(String number);
    Card save(Card card);
    void deleteById(String uuid);
}
