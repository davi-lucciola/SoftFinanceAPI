package io.api.softfinance.domain.services;

import io.api.softfinance.domain.errors.DomainError;
import io.api.softfinance.domain.errors.NoContentError;
import io.api.softfinance.domain.errors.NotFoundError;
import io.api.softfinance.domain.interfaces.repositories.IBankRepository;
import io.api.softfinance.domain.interfaces.services.IBankService;
import io.api.softfinance.domain.models.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService implements IBankService {

    @Autowired
    private IBankRepository bankRepository;

    @Override
    public List<Bank> findAll(String search) {
        List<Bank> banks = bankRepository.findAll(search);

        if (banks.isEmpty())
            throw new NoContentError();

        if (search != null) {
            banks = banks.stream().filter((bank) -> bank.getName().contains(search)).toList();
        }

        return banks;
    }

    @Override
    public Bank findById(String uuid) {
        Bank bank = bankRepository.findById(uuid);

        if (bank == null)
            throw new NotFoundError("O banco não foi encontrado.");

        return bank;
    }

    @Override
    public Bank create(Bank bank) {
        Bank bankInDB = bankRepository.findByName(bank.getName());

        if (bankInDB != null)
            throw new DomainError("Já existe um banco cadastrado com esse nome.");

        return bankRepository.save(bank);
    }

    @Override
    public Bank update(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public void delete(String bankUuid) {
        bankRepository.deleteById(bankUuid);
    }
}
