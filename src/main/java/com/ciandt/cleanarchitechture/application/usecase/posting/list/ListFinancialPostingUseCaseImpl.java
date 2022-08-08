package com.ciandt.cleanarchitechture.application.usecase.posting.list;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.infrastructure.repository.FinancialPostingRepository;
import com.ciandt.cleanarchitechture.infrastructure.repository.PostingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.ciandt.cleanarchitechture.application.usecase.posting.list.SearchParamsDto.convert;

@Service
public class ListFinancialPostingUseCaseImpl implements ListFinancialPostingUseCase {

    @Autowired
    FinancialPostingRepository financialPostingRepository;

    @Autowired
    PostingTypeRepository postingTypeRepository;

    @Override
    public Page<FinancialPostingOutput> execute(ListFinancialPostingInput form, Pageable pageable) {
        SearchParamsDto searchParams = convert(form, postingTypeRepository);
        Page<FinancialPostingEntity> postings = financialPostingRepository
                .findByIsActiveAndTypeOrIsActiveAndDateBetween(true, searchParams.getPostingType(), true, searchParams.getStartDate(), searchParams.getEndDate(), pageable);
        return FinancialPostingOutput.convertToPage(postings);
    }

}
