package com.ciandt.cleanarchitechture.application.usecase.posting.list;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListFinancialPostingUseCase {

    Page<FinancialPostingOutput> execute(ListFinancialPostingInput form, Pageable pageable);

}
