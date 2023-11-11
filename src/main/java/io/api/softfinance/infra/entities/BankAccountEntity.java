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
@Table(name = "bank_accounts")
public class BankAccountEntity {
    @Id
    @UuidGenerator
    private String uuid;

    @Column(nullable = false)
    private String holder;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String agency;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "bankId", referencedColumnName = "uuid")
    private BankEntity bank;

    @OneToMany(mappedBy = "bankAccount")
    private List<CardEntity> cards;
}
