package com.ciandt.cleanarchitechture.application.usecase.posting.edit;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;

public interface EditFinancialPostingUseCase {

    FinancialPostingOutput execute(Long postId, EditFinancialPostingInput form);

}
