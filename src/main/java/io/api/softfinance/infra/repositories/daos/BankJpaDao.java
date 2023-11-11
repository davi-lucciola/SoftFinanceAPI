package io.api.softfinance.infra.repositories.daos;

import io.api.softfinance.infra.entities.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankJpaDao extends JpaRepository<BankEntity, String> {
    @Query(value = "SELECT b FROM BankEntity b WHERE b.name LIKE ?1")
    List<BankEntity> searchByName(String name);
    Optional<BankEntity> findByName(String name);
}
