package io.api.softfinance.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigInteger;

@Getter
@AllArgsConstructor
public enum OperationType {
    DEBITO(1, "Débito"),
    CREDITO(2, "Crédito"),
    TRANSFERENCIA(3, "Trânsferência Bancária."),
    PIX(4, "Pix");

    private final Integer id;
    private final String descricao;
}
