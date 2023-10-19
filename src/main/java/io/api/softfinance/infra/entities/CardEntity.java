package io.api.softfinance.infra.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Calendar;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card")
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
}
