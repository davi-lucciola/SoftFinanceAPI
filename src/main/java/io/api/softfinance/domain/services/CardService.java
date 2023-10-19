package io.api.softfinance.domain.services;

import io.api.softfinance.domain.interfaces.ICardRepository;
import io.api.softfinance.domain.models.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private ICardRepository cardRepository;

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findById(String uuid) {
        return cardRepository.findById(uuid);
    }

    public Card create(Card card) throws Exception {
        card.validate();
        return cardRepository.save(card);
    }

    public void delete(String uuid) throws Exception {
        if (cardRepository.findById(uuid) == null) {
            throw new Exception("Cartão não encontrado.");
        }

        cardRepository.deleteById(uuid);
    }
}
