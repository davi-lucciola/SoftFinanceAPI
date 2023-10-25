package io.api.softfinance.repositories;

import io.api.softfinance.converters.CardConverter;
import io.api.softfinance.interfaces.ICardRepository;
import io.api.softfinance.models.Card;
import io.api.softfinance.repositories.daos.CardJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepository implements ICardRepository {
    @Autowired
    private CardJpaDao cardJpaDao;

    public List<Card> findAll() {
        return cardJpaDao.findAll().stream().map(CardConverter::convert).toList();
    }

    public Card findById(String uuid) {
        return CardConverter.convert(cardJpaDao.findById(uuid).orElse(null));
    }

    public Card save(Card card) {
        return CardConverter.convert(cardJpaDao.saveAndFlush(CardConverter.convert(card)));
    }

    public void deleteById(String uuid) {
        cardJpaDao.deleteById(uuid);
    }
}
