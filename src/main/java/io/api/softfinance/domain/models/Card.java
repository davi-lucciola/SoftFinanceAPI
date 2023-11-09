package io.api.softfinance.domain.models;

import io.api.softfinance.domain.errors.InvalidEntityError;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String uuid;

    @NotEmpty(message = "O campo \"numero\" é obrigatório.")
    private String numero;

    @NotEmpty(message = "O campo \"nomeImpresso\" é obrigatório.")
    private String nomeImpresso;

    @NotEmpty(message = "O campo \"cvv\" é obrigatório.")
    private String cvv;

    @NotNull(message = "O campo \"dataVencimento\" é obrigatório. (yyyy-MM-dd)")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar dataVencimento;

    @NotNull(message = "O \"limiteTotal\" é obrigatório.")
    private BigDecimal limiteTotal;

    private BigDecimal limiteUtilizado;

    @NotNull(message = "O campo contaBancariaId é obrigatório.")
    private String contaBancariaId;

    private BankAccount contaBancaria;

    public void validate() throws InvalidEntityError {
        if (Calendar.getInstance().after(this.dataVencimento)) {
            throw new InvalidEntityError("A data de vencimento não pode ser anterior a data atual.");
        }

        this.limiteUtilizado = BigDecimal.ZERO;
    }
}
