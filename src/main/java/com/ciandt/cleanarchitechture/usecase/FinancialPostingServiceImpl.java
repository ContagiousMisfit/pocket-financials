package com.ciandt.cleanarchitechture.usecase;

import com.ciandt.cleanarchitechture.adapter.controller.form.FinancialPostingForm;
import com.ciandt.cleanarchitechture.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.repository.FinancialPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FinancialPostingServiceImpl implements FinancialPostingService {

    @Autowired
    FinancialPostingRepository financialPostingRepository;

    @Override
    public Page<FinancialPostingEntity> getPostingByTypeOrPeriod(FinancialPostingForm form, Pageable pageable) {
        return financialPostingRepository.findByTypeOrDateBetween(form.getPostingTypeEntity(), form.getStartingDate(), form.getEndingDate(), pageable);
    }

    @Override
    public Page<FinancialPostingEntity> getAllData(Pageable pageable) {
        return null;
    }
}
