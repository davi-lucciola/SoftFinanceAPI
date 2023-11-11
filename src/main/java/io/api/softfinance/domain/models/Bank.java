package io.api.softfinance.domain.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private String uuid;

    @NotEmpty(message = "O campo nome é obrigatório.")
    private String name;

    public Bank(String uuid) {
        this.uuid = uuid;
    }
}
