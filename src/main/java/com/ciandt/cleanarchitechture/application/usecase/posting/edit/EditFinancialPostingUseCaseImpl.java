package com.ciandt.cleanarchitechture.application.usecase.posting.edit;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.infrastructure.repository.FinancialPostingRepository;
import com.ciandt.cleanarchitechture.infrastructure.repository.PostingTypeRepository;
import com.ciandt.cleanarchitechture.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditFinancialPostingUseCaseImpl implements EditFinancialPostingUseCase {

    @Autowired
    PostingTypeRepository postingTypeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FinancialPostingRepository financialPostingRepository;

    public FinancialPostingOutput execute(Long postId, EditFinancialPostingInput form) {
        FinancialPostingEntity posting = form.edit(postId, postingTypeRepository, userRepository, financialPostingRepository);
        return new FinancialPostingOutput(posting);
    }

}
