package io.api.softfinance.domain.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidEntityException extends DomainException{
    public InvalidEntityException(String message) {
        super(message);
    }
}
