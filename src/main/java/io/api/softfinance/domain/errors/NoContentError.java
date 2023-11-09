package io.api.softfinance.domain.errors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentError extends DomainError {
    public NoContentError() {}
}
