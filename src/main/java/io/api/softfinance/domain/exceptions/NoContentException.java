package io.api.softfinance.domain.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoContentException extends DomainException {
    public NoContentException() {}
}
