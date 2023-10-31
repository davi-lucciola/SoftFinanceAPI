package io.api.softfinance.interfaces;

import io.api.softfinance.models.Card;

import java.util.List;

public interface ICardRepository {
    List<Card> findAll();
    Card findById(String uuid);

    Card findByNumber(String number);
    Card save(Card card);
    void deleteById(String uuid);
}
