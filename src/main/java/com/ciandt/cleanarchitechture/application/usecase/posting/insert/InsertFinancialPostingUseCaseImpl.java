package com.ciandt.cleanarchitechture.application.usecase.posting.insert;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.infrastructure.repository.FinancialPostingRepository;
import com.ciandt.cleanarchitechture.infrastructure.repository.PostingTypeRepository;
import com.ciandt.cleanarchitechture.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertFinancialPostingUseCaseImpl implements InsertFinancialPostingUseCase {

    @Autowired
    FinancialPostingRepository financialPostingRepository;

    @Autowired
    PostingTypeRepository postingTypeRepository;

    @Autowired
    UserRepository userRepository;

    public FinancialPostingOutput execute(InsertFinancialPostingInput form) {
        FinancialPostingEntity posting = form.convert(postingTypeRepository, userRepository);
        financialPostingRepository.save(posting);
        return new FinancialPostingOutput(posting);
    }

}
