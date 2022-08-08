package com.ciandt.cleanarchitechture.application.usecase.posting.remove;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;

public interface RemoveFinancialPostingUseCase {

    FinancialPostingOutput execute(Long postId);

}
