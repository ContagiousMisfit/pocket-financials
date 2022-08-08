package com.ciandt.cleanarchitechture.infrastructure.repository;

import com.ciandt.cleanarchitechture.domain.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long> {}
