package com.ciandt.cleanarchitechture.infrastructure.repository;

import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.domain.entity.PostingType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FinancialPostingRepository extends JpaRepository<FinancialPostingEntity, Long> {

    Page<FinancialPostingEntity> findByTypeOrDateBetween(PostingType postingType, LocalDate startDate, LocalDate endDate, Pageable pageable);

}

