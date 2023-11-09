package io.api.softfinance.domain.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    private String uuid;

    @NotEmpty(message = "O titular não pode ser vazio.")
    private String titular;

    @Min(value = 0, message = "O valor do saldo deve ser positivo.")
    private BigDecimal saldo = BigDecimal.ZERO;

    private List<Card> cartoes;

    private Bank bank;


}
