package io.api.softfinance.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @NotEmpty(message = "O campo \"number\" é obrigatório.")
    private String number;

    @NotEmpty(message = "O campo \"printedName\" é obrigatório.")
    private String printedName;

    @NotEmpty(message = "O campo \"cvv\" é obrigatório.")
    private String cvv;

    @NotNull(message = "O campo \"dueDate\" é obrigatório. (yyyy-MM-dd)")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar dueDate;

    @NotNull(message = "O \"totalLimit\" é obrigatório.")
    private BigDecimal totalLimit;

    private BigDecimal limitUsed;

    @JsonIgnore
    @NotNull(message = "O \"campo bankAccountId\" é obrigatório.")
    private String bankAccountId;

    private BankAccount bankAccount;

    public void validate() throws InvalidEntityError {
        if (Calendar.getInstance().after(this.dueDate)) {
            throw new InvalidEntityError("A data de vencimento não pode ser anterior a data atual.");
        }

        this.limitUsed = BigDecimal.ZERO;
    }
}
