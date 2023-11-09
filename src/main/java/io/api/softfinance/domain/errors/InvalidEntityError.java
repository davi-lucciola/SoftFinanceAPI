package io.api.softfinance.domain.errors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidEntityError extends DomainError {
    public InvalidEntityError(String message) {
        super(message);
    }
}
