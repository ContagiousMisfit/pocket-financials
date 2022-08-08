package com.ciandt.cleanarchitechture.application.usecase.posting.insert;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;

public interface InsertFinancialPostingUseCase {

    FinancialPostingOutput execute(InsertFinancialPostingInput form);

}
