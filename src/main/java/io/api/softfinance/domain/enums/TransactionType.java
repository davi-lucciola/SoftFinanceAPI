package io.api.softfinance.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransactionType {
    ENTRADA(1, "Transação de Entrada"),
    SAIDA(2, "Transação de Saída");

    private final Integer id;
    private final String descricao;
}
