package io.api.softfinance.infra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.Calendar;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cartoes")
public class CardEntity {
    @Id
    @UuidGenerator
    private String uuid;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(name = "nome_impresso", nullable = false, unique = true)
    private String nomeImpresso;

    @Column(nullable = false)
    private String cvv;

    @Column(name = "data_vencimento", nullable = false)
    private Calendar dataVencimento;

    @Column(nullable = false)
    private BigDecimal limiteTotal;

    @Column(nullable = false)
    private BigDecimal limiteUtilizado;

    @ManyToOne
    @JoinColumn(name = "conta_bancaria_id", referencedColumnName = "uuid", nullable = false)
    private BankAccountEntity contaBancaria;
}
