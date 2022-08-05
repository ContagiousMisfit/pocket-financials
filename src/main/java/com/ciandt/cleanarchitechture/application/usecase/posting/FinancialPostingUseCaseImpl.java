package com.ciandt.cleanarchitechture.application.usecase.posting;

import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.infrastructure.repository.FinancialPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FinancialPostingUseCaseImpl implements FinancialPostingService {

    @Autowired
    FinancialPostingRepository financialPostingRepository;

    @Override
    public Page<FinancialPostingEntity> getPostingByTypeOrPeriod(FinancialPostingInput form, Pageable pageable) {
        return financialPostingRepository.findByTypeOrDateBetween(form.getPostingType(), form.getStartingDate(), form.getEndingDate(), pageable);
    }

}
