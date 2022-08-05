package com.ciandt.cleanarchitechture.usecase;

import com.ciandt.cleanarchitechture.adapter.controller.form.FinancialPostingForm;
import com.ciandt.cleanarchitechture.entity.FinancialPostingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FinancialPostingService {

    Page<FinancialPostingEntity> getPostingByTypeOrPeriod(FinancialPostingForm form, Pageable pageable);

    Page<FinancialPostingEntity> getAllData(Pageable pageable);

}
