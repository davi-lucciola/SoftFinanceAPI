package io.api.softfinance.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends DomainException {
    public NotFoundException(String message) {
        super(message);
    }
}
