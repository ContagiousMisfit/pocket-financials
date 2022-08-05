package com.ciandt.cleanarchitechture.application.usecase.posting;

import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FinancialPostingUseCase {

    FinancialPostingOutput getPostingByTypeOrPeriod(FinancialPostingInput form, Pageable pageable);

}
