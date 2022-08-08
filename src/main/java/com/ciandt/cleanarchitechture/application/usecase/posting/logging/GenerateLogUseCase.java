package com.ciandt.cleanarchitechture.application.usecase.posting.logging;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.domain.entity.LogAction;

public interface GenerateLogUseCase {

    void execute(FinancialPostingOutput post, LogAction logAction);

}
