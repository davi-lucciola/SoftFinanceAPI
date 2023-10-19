package io.api.softfinance.domain.interfaces;

import io.api.softfinance.domain.models.Card;

import java.util.List;

public interface ICardRepository {
    List<Card> findAll();
    Card findById(String uuid);
    Card save(Card card);
    void deleteById(String uuid);
}
