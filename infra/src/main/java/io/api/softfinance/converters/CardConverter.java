package io.api.softfinance.converters;


import io.api.softfinance.entities.CardEntity;
import io.api.softfinance.models.Card;

public class CardConverter {
    public static Card convert(CardEntity entity) {
        if (entity == null) return null;

        Card domain = new Card();

        domain.setUuid(entity.getUuid());
        domain.setNumero(entity.getNumero());
        domain.setNomeImpresso(entity.getNomeImpresso());
        domain.setDataVencimento(entity.getDataVencimento());
        domain.setCvv(entity.getCvv());

        return domain;
    }

    public static CardEntity convert(Card domain) {
        if (domain == null) return null;

        CardEntity entity = new CardEntity();

        entity.setUuid(domain.getUuid());
        entity.setNumero(domain.getNumero());
        entity.setNomeImpresso(domain.getNomeImpresso());
        entity.setDataVencimento(domain.getDataVencimento());
        entity.setCvv(domain.getCvv());

        return entity;
    }
}
