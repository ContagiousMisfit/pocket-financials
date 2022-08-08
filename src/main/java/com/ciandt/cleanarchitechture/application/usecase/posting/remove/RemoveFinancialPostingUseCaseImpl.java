package com.ciandt.cleanarchitechture.application.usecase.posting.remove;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.infrastructure.repository.FinancialPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class RemoveFinancialPostingUseCaseImpl implements RemoveFinancialPostingUseCase {

    @Autowired
    FinancialPostingRepository financialPostingRepository;

    @Override
    public FinancialPostingOutput execute(Long postId) {
        Optional<FinancialPostingEntity> optional = financialPostingRepository.findById(postId);
        if (optional.isPresent()) {
            FinancialPostingEntity posting = optional.get();
            posting.setActive(false);
            return new FinancialPostingOutput(posting);
        }
        throw new EntityNotFoundException();
    }

}
