package com.ciandt.cleanarchitechture.application.usecase.posting.list;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListFinancialPostingUseCase {

    Page<ListFinancialPostingOutput> execute(ListFinancialPostingInput form, Pageable pageable);

}
