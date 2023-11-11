package io.api.softfinance.infra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "banks")
public class BankEntity {
    @Id
    @UuidGenerator
    private String uuid;

    @Column(unique = true, nullable = false)
    private String name;
}
