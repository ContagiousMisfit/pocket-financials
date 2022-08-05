package com.ciandt.cleanarchitechture.repository;

import com.ciandt.cleanarchitechture.adapter.controller.form.FinancialPostingForm;
import com.ciandt.cleanarchitechture.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.entity.PostingTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FinancialPostingRepository extends JpaRepository<FinancialPostingEntity, Long> {

    Page<FinancialPostingEntity> findByTypeOrDateBetween(PostingTypeEntity postingTypeEntity, LocalDate startDate, LocalDate endDate, Pageable pageable);

    //findByNameContainingIgnoreCaseOrArtistNameContainingIgnoreCaseOrderByArtistNameAscName
}

