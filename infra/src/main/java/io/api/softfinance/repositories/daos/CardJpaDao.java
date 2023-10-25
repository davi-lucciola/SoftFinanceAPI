package io.api.softfinance.repositories.daos;

import io.api.softfinance.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardJpaDao extends JpaRepository<CardEntity, String> {
}
