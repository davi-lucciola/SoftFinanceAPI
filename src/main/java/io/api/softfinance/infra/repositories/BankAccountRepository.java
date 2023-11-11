package io.api.softfinance.infra.repositories;

import io.api.softfinance.domain.interfaces.repositories.IBankAccountRepository;
import io.api.softfinance.domain.models.BankAccount;
import io.api.softfinance.infra.converters.BankAccountConverter;
import io.api.softfinance.infra.repositories.daos.BankAccountJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankAccountRepository implements IBankAccountRepository {

    @Autowired
    private BankAccountJpaDao bankAccountJpaDao;

    @Override
    public List<BankAccount> findAll() {
        return bankAccountJpaDao.findAll().stream().map(BankAccountConverter::convert).toList();
    }

    @Override
    public BankAccount findById(String uuid) {
        return bankAccountJpaDao.findById(uuid).map(BankAccountConverter::convert).orElse(null);
    }

    @Override
    public BankAccount findByBankAndAccountNumber(String bankUuid, String accountNumber) {
        return bankAccountJpaDao.findByBankIdAndAccountNumber(bankUuid, accountNumber)
                .map(BankAccountConverter::convert).orElse(null);
    }

    @Override
    public BankAccount save(BankAccount bankAccount) {
        return BankAccountConverter.convert(bankAccountJpaDao
                .saveAndFlush(BankAccountConverter.convert(bankAccount)));
    }
}
