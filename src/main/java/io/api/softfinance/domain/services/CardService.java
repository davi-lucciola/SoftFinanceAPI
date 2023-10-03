package io.api.softfinance.domain.services;

import io.api.softfinance.domain.models.Card;
import io.api.softfinance.infra.entities.CardEntity;
import io.api.softfinance.infra.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> findAll() {
        List<CardEntity> cardEntitys = cardRepository.findAll();
        return cardEntitys.stream().map(Card::fromEntity).toList();
    }

    public Card save(Card card) throws Exception {
        card.validate();
        return Card.fromEntity(cardRepository.saveAndFlush(card.toEntity()));
    }

    //public Card update() {

    //}

    //public Card delete() {

    //}
}
