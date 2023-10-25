package io.api.softfinance.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String uuid;

    @NotEmpty(message = "O campo numero é obrigatório.")
    private String numero;

    @NotEmpty(message = "O campo numero é obrigatório.")
    private String nomeImpresso;

    @NotEmpty(message = "O campo numero é obrigatório.")
    private String cvv;

    @NotNull(message = "O campo numero é obrigatório.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar dataVencimento;

    public void validate() throws Exception {
        if (Calendar.getInstance().after(this.dataVencimento)) {
            throw new Exception("A data de vencimento não pode ser anterior a data atual.");
        }
    }
}
