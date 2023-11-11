package io.api.softfinance.services;

import io.api.softfinance.domain.interfaces.repositories.IBankAccountRepository;
import io.api.softfinance.domain.interfaces.repositories.IBankRepository;
import io.api.softfinance.domain.interfaces.services.IBankService;
import io.api.softfinance.domain.services.BankAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BankAccountServiceTest {
    @InjectMocks
    private BankAccountService bankAccountService;
    @Mock
    private IBankAccountRepository bankAccountRepository;
    @Mock
    private IBankService bankService;
}
