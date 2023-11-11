package io.api.softfinance.infra.repositories.daos;

import io.api.softfinance.infra.entities.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountJpaDao extends JpaRepository<BankAccountEntity, String> {

    @Query(value = "SELECT ba FROM BankAccountEntity ba WHERE ba.bank.uuid = ?1 AND ba.accountNumber = ?2")
    Optional<BankAccountEntity> findByBankIdAndAccountNumber(String bankId, String accountNumber);
}
