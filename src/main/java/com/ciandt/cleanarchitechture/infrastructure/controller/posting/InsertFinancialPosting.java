package com.ciandt.cleanarchitechture.infrastructure.controller.posting;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.application.usecase.posting.insert.InsertFinancialPostingInput;
import com.ciandt.cleanarchitechture.application.usecase.posting.insert.InsertFinancialPostingUseCase;
import com.ciandt.cleanarchitechture.application.usecase.posting.logging.GenerateLogUseCase;
import com.ciandt.cleanarchitechture.domain.entity.LogAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/post/insert")
public class InsertFinancialPosting {

    @Autowired
    InsertFinancialPostingUseCase insertFinancialPostingUseCase;

    @Autowired
    GenerateLogUseCase generateLogUseCase;

    @PostMapping
    @Transactional
    public ResponseEntity<FinancialPostingOutput> insertFinancialPosting(@RequestBody @Valid InsertFinancialPostingInput form) {
        FinancialPostingOutput posting = insertFinancialPostingUseCase.execute(form);
        generateLogUseCase.execute(posting, LogAction.INSERTED);
        return ResponseEntity.status(201).body(posting);
    }

}
