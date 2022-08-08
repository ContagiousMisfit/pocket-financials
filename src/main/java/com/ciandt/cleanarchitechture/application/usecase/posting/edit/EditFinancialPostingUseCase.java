package com.ciandt.cleanarchitechture.application.usecase.posting.edit;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import org.springframework.data.domain.Pageable;

public interface EditFinancialPostingUseCase {

    FinancialPostingOutput execute(EditFinancialPostingInput form, Pageable pageable);

}
