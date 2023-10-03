package io.api.softfinance.domain.models;

import io.api.softfinance.infra.entities.CardEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    private String uuid;

    @NotEmpty(message = "O campo numero é obrigatório.")
    @Pattern(regexp = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$")
    private String numero;

    @NotEmpty(message = "O campo numero é obrigatório.")
    private String nomeImpresso;

    @NotEmpty(message = "O campo numero é obrigatório.")
    private String cvv;

    @NotNull(message = "O campo numero é obrigatório.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataVencimento;

    public void validate() throws Exception {
        if (Calendar.getInstance().after(this.dataVencimento)) {
            throw new Exception("A data de vencimento não pode ser anterior a data atual.");
        }
    }

    public static Card fromEntity(CardEntity cardEntity) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date dataVencimento = dateFormat.parse(cardEntity.getDataVencimento().toString());
        return new Card(cardEntity.getUuid(), cardEntity.getNumero(),
                cardEntity.getNomeImpresso(), cardEntity.getCvv(), dataVencimento);
    }

    public CardEntity toEntity() {
        Calendar dataVencimento = Calendar.getInstance();
        dataVencimento.setTime(this.getDataVencimento());
        return new CardEntity(this.getUuid(), this.getNumero(),
                this.getNomeImpresso(), this.getCvv(), dataVencimento);
    }
}
