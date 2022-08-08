package com.ciandt.cleanarchitechture.infrastructure.controller.posting;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.application.usecase.posting.logging.GenerateLogUseCase;
import com.ciandt.cleanarchitechture.application.usecase.posting.remove.RemoveFinancialPostingUseCase;
import com.ciandt.cleanarchitechture.domain.entity.LogAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/post/remove")
public class RemoveFinancialPosting {

    @Autowired
    private RemoveFinancialPostingUseCase removeFinancialPostingUseCase;

    @Autowired
    private GenerateLogUseCase generateLogUseCase;

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<FinancialPostingOutput> removeFinancialPosting(@PathVariable Long id) {
        FinancialPostingOutput posting = removeFinancialPostingUseCase.execute(id);
        generateLogUseCase.execute(posting, LogAction.REMOVED);
        return ResponseEntity.ok().body(posting);
    }
}
