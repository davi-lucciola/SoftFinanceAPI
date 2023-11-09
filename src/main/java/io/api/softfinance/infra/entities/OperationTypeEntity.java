package io.api.softfinance.infra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipos_operacoes")
public class OperationTypeEntity {
    @Id
    @UuidGenerator
    private String uuid;

    @Column(unique = true, nullable = false)
    private String descricao;
}
