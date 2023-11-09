package io.api.softfinance.infra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transacoes")
public class TransactionEntity {

    @Id
    @UuidGenerator
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "tipo_operacao_id", referencedColumnName = "uuid")
    private OperationTypeEntity tipoOperacao;

    @Column(nullable = false)
    private String tipoTransacao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private Calendar dataTransacao;

    @ManyToOne
    @JoinColumn(name = "cartao_id", referencedColumnName = "uuid")
    private CardEntity cartao;
}
