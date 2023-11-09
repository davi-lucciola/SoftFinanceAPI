package io.api.softfinance.infra.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contas_bancarias")
public class BankAccountEntity {
    @Id
    @UuidGenerator
    private String uuid;

    @Column(nullable = false)
    private String titular;

    @Column(nullable = false)
    private BigDecimal saldo = BigDecimal.ZERO;

//    @ManyToOne
//    @JoinColumn(name = "banco_id", referencedColumnName = "id")
//    private BankEntity banco;

    @OneToMany(mappedBy = "contaBancaria")
    private List<CardEntity> cartoes;
}
