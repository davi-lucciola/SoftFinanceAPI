package io.api.softfinance.domain.services;


import io.api.softfinance.domain.errors.DomainError;
import io.api.softfinance.domain.errors.NoContentError;
import io.api.softfinance.domain.errors.NotFoundError;
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

        if (cards.isEmpty())
            throw new NoContentError();


        return cards;
    }

    public Card findById(String uuid) {
        Card card = cardRepository.findById(uuid);

        if (card == null)
            throw new NotFoundError("Cartão não encontrado.");

        return card;
    }

    public Card create(Card card) throws DomainError {
        card.validate();

        if (cardRepository.findByNumber(card.getNumero()) != null)
            throw new DomainError("Esse cartão já está cadastrado.");

        return cardRepository.save(card);
    }

    public void delete(String uuid) throws NotFoundError {
        findById(uuid);
        cardRepository.deleteById(uuid);
    }
}
