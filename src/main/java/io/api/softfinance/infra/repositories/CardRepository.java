package io.api.softfinance.infra.repositories;

import io.api.softfinance.domain.interfaces.repositories.ICardRepository;
import io.api.softfinance.domain.models.Card;
import io.api.softfinance.infra.converters.CardConverter;
import io.api.softfinance.infra.repositories.daos.CardJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepository implements ICardRepository {
    @Autowired
    private CardJpaDao cardJpaDao;

    @Override
    public List<Card> findAll() {
        return cardJpaDao.findAll().stream().map(CardConverter::convert).toList();
    }

    @Override
    public Card findById(String uuid) {
        return CardConverter.convert(cardJpaDao.findById(uuid).orElse(null));
    }

    @Override
    public Card findByNumber(String number) {
        return null;
    }

    @Override
    public Card save(Card card) {
        return CardConverter.convert(cardJpaDao.saveAndFlush(CardConverter.convert(card)));
    }

    @Override
    public void deleteById(String uuid) {
        cardJpaDao.deleteById(uuid);
    }
}
