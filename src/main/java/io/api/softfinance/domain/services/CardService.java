package io.api.softfinance.domain.services;


import io.api.softfinance.domain.exceptions.DomainException;
import io.api.softfinance.domain.exceptions.NoContentException;
import io.api.softfinance.domain.exceptions.NotFoundException;
import io.api.softfinance.domain.interfaces.services.ICardService;
import io.api.softfinance.domain.interfaces.repositories.ICardRepository;
import io.api.softfinance.domain.models.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements ICardService {

    @Autowired
    private ICardRepository cardRepository;

    public List<Card> findAll() {
        List<Card> cards = cardRepository.findAll();

        if (cards.isEmpty()) {
            throw new NoContentException();
        }

        return cards;
    }

    public Card findById(String uuid) {
        Card card = cardRepository.findById(uuid);

        if (card == null) {
            throw new NotFoundException("Cartão não encontrado.");
        }

        return card;
    }

    public Card create(Card card) throws DomainException {
        card.validate();

        if (cardRepository.findByNumber(card.getNumero()) != null) {
            throw new DomainException("Esse cartão já está cadastrado.");
        }

        return cardRepository.save(card);
    }

    public void delete(String uuid) throws NotFoundException {
        findById(uuid);
        cardRepository.deleteById(uuid);
    }
}
