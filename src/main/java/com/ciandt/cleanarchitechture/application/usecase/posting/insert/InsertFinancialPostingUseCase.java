package com.ciandt.cleanarchitechture.application.usecase.posting.insert;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import org.springframework.data.domain.Pageable;

public interface InsertFinancialPostingUseCase {

    FinancialPostingOutput execute(InsertFinancialPostingInput form, Pageable pageable);

}
