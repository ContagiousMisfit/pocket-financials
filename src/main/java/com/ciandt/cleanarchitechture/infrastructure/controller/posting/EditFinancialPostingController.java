package com.ciandt.cleanarchitechture.infrastructure.controller.posting;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.application.usecase.posting.edit.EditFinancialPostingInput;
import com.ciandt.cleanarchitechture.application.usecase.posting.edit.EditFinancialPostingUseCase;
import com.ciandt.cleanarchitechture.application.usecase.posting.logging.GenerateLogUseCase;
import com.ciandt.cleanarchitechture.domain.entity.LogAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/post/edit")
public class EditFinancialPostingController {

    @Autowired
    EditFinancialPostingUseCase editFinancialPostingUseCase;

    @Autowired
    GenerateLogUseCase generateLogUseCase;

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FinancialPostingOutput> editFinancialPosting(@PathVariable Long id, @RequestBody @Valid EditFinancialPostingInput form) {
        FinancialPostingOutput posting = editFinancialPostingUseCase.execute(form);
        generateLogUseCase.execute(posting, LogAction.EDITED);
        return ResponseEntity.ok().body(posting);
    }

}
