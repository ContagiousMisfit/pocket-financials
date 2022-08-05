package com.ciandt.cleanarchitechture.application.usecase.posting;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FinancialPostingUseCase {

    Page<FinancialPostingOutput> getPostingByTypeOrPeriod(FinancialPostingInput form, Pageable pageable);

}
