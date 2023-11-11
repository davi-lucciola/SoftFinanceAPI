package io.api.softfinance.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    private String uuid;

    @NotEmpty(message = "O campo \"holder\" é obrigatório.")
    private String holder;

    @NotEmpty(message = "O campo \"accountNumber\" é obrigatório.")
    private String accountNumber;

    @NotEmpty(message = "O campo \"agency\" é obrigatório.")
    private String agency;

    @Min(value = 0, message = "O campo \"balance\" não pode ser menor que zero.")
    private BigDecimal balance = BigDecimal.ZERO;

    @JsonIgnore
    @NotEmpty(message = "O campo \"bankId\" não pode ser menor que zero.")
    private String bankUuid;

    private Bank bank;
}
