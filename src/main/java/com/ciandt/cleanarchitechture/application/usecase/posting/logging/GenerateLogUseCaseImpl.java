package com.ciandt.cleanarchitechture.application.usecase.posting.logging;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.domain.entity.LogAction;
import com.ciandt.cleanarchitechture.domain.entity.LogEntity;
import com.ciandt.cleanarchitechture.infrastructure.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GenerateLogUseCaseImpl implements GenerateLogUseCase {

    @Autowired
    LogRepository logRepository;

    @Override
    public void execute(FinancialPostingOutput post, LogAction logAction) {
        LogEntity log = LogEntity
                .builder()
                .user(post.getUser())
                .action(logAction.name())
                .actionDate(LocalDate.now())
                .postingId(post.getId())
                .build();
        logRepository.save(log);
    }

}
