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
    private String number;

    @Column(name = "printedName", nullable = false, unique = true)
    private String printedName;

    @Column(nullable = false)
    private String cvv;

    @Column(name = "due_date", nullable = false)
    private Calendar dueDate;

    @Column(nullable = false)
    private BigDecimal totalLimit;

    @Column(nullable = false)
    private BigDecimal limitUsed;

    @ManyToOne
    @JoinColumn(name = "bank_account_id", referencedColumnName = "uuid", nullable = false)
    private BankAccountEntity bankAccount;
}
