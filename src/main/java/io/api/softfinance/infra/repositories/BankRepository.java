package io.api.softfinance.infra.repositories;

import io.api.softfinance.domain.interfaces.repositories.IBankRepository;
import io.api.softfinance.domain.models.Bank;
import io.api.softfinance.infra.converters.BankConverter;
import io.api.softfinance.infra.entities.BankEntity;
import io.api.softfinance.infra.repositories.daos.BankJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankRepository implements IBankRepository {

    @Autowired
    private BankJpaDao bankJpaDao;

    @Override
    public List<Bank> findAll(String search) {
        List<BankEntity> banks = search == null ?
                bankJpaDao.findAll() : bankJpaDao.searchByName(search);

        return banks.stream().map(BankConverter::convert).toList();
    }

    @Override
    public Bank findById(String uuid) {
        return bankJpaDao.findById(uuid).map(BankConverter::convert).orElse(null);
    }

    @Override
    public Bank findByName(String name) {
        return bankJpaDao.findByNome(name).map(BankConverter::convert).orElse(null);
    }

    @Override
    public Bank save(Bank bank) {
        return BankConverter.convert(bankJpaDao.saveAndFlush(BankConverter.convert(bank)));
    }

    @Override
    public void deleteById(String uuid) {
        bankJpaDao.deleteById(uuid);
    }
}
