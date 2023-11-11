package io.api.softfinance.services;

import io.api.softfinance.domain.errors.DomainError;
import io.api.softfinance.domain.errors.NoContentError;
import io.api.softfinance.domain.interfaces.repositories.ICardRepository;
import io.api.softfinance.domain.models.Card;
import io.api.softfinance.domain.services.CardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CardServiceTest {

    @InjectMocks
    private CardService cardService;

    @Mock
    private ICardRepository cardRepository;

    @Test
    public void FindAll_NoContent() {
        when(cardRepository.findAll()).thenReturn(new ArrayList<>());

        Assertions.assertThrows(NoContentError.class, () -> {
            cardService.findAll();
        });
    }

    @Test
    public void FindByUuid_NotFound() {
        String cardUuid = String.valueOf(UUID.randomUUID());
        when(cardRepository.findById(cardUuid)).thenReturn(null);

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            cardService.findById(cardUuid);
        });

        Assertions.assertEquals("Cartão não encontrado.", exception.getMessage());
    }

    @Test
    public void Delete_NotFound() {
        String cardUuid = String.valueOf(UUID.randomUUID());
        when(cardRepository.findById(cardUuid)).thenReturn(null);

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            cardService.delete(cardUuid);
        });

        Assertions.assertEquals("Cartão não encontrado.", exception.getMessage());
    }

    @Test
    public void Create_DataVencimentoMenorDataAtual() {
        Card card = new Card();
        card.setDueDate(Calendar.getInstance());
        card.getDueDate().add(Calendar.DAY_OF_MONTH, -3);

        Exception exception = Assertions.assertThrows(DomainError.class, () -> {
            cardService.create(card);
        });

        Assertions.assertEquals("A data de vencimento não pode ser anterior a data atual.", exception.getMessage());
    }

    @Test
    public void Create_CartaoJaCadastrado() {
        Card card = new Card();
        card.setNumber("RANDOM_NUMBER");
        Calendar closingDate = Calendar.getInstance();
        closingDate.add(Calendar.MONTH, 24);
        card.setDueDate(closingDate);

        when(cardRepository.findByNumber(card.getNumber())).thenReturn(new Card());

        Exception exception = Assertions.assertThrows(DomainError.class, () -> {
            cardService.create(card);
        });

        Assertions.assertEquals("Esse cartão já está cadastrado.", exception.getMessage());
    }

    @Test
    public void Create_Sucesso() {
        Card card = new Card();
        card.setNumber("RANDOM_NUMBER");
        Calendar closingDate = Calendar.getInstance();
        closingDate.add(Calendar.MONTH, 24);
        card.setDueDate(closingDate);

        when(cardRepository.findByNumber(card.getNumber())).thenReturn(null);
        when(cardRepository.save(card)).thenReturn(card);

        Card cardInDb = cardService.create(card);

        verify(cardRepository).save(card);

    }
}
