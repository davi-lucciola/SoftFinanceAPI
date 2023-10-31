package io.api.softfinance.services;

import io.api.softfinance.interfaces.ICardRepository;
import io.api.softfinance.models.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Calendar;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CardServiceTest {

    @InjectMocks
    private CardService cardService;

    @Mock
    private ICardRepository cardRepository;

    @Test
    public void Card_DataVencimentoMenorDataAtual() {
        Card card = new Card();
        card.setDataVencimento(Calendar.getInstance());
        card.getDataVencimento().add(Calendar.DAY_OF_MONTH, -3);

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            cardService.create(card);
        });

        Assertions.assertEquals("A data de vencimento não pode ser anterior a data atual.", exception.getMessage());
    }
}
