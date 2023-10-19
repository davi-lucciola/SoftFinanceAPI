package io.api.softfinance.infra.repositories.daos;

import io.api.softfinance.infra.entities.CardEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardJpaDao extends JpaRepository<CardEntity, String> {
}
