package com.ciandt.cleanarchitechture.infrastructure.controller.posting;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.application.usecase.posting.insert.InsertFinancialPostingInput;
import com.ciandt.cleanarchitechture.application.usecase.posting.insert.InsertFinancialPostingUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/post/insert")
public class InsertFinancialPostingController {

    @Autowired
    InsertFinancialPostingUseCase insertFinancialPostingUseCase;

    @PostMapping
    public ResponseEntity<FinancialPostingOutput> insertFinancialPosting(@RequestBody @Valid InsertFinancialPostingInput form) {
        Pageable pageable = PageRequest.of(0, 50);
        FinancialPostingOutput posting = insertFinancialPostingUseCase.execute(form, pageable);
        return ResponseEntity.status(201).body(posting);
    }

}
