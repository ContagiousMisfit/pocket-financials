package com.ciandt.cleanarchitechture.application.usecase.posting.list;

import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.infrastructure.repository.FinancialPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListFinancialPostingUseCaseImpl implements ListFinancialPostingUseCase {

    @Autowired
    FinancialPostingRepository financialPostingRepository;

    @Override
    public Page<ListFinancialPostingOutput> execute(ListFinancialPostingInput form, Pageable pageable) {
        Page<FinancialPostingEntity> postings = financialPostingRepository
                .findByTypeOrDateBetween(form.getPostingType(), form.getStartingDate(), form.getEndingDate(), pageable);
        return ListFinancialPostingOutput.convert(postings);
    }

}
