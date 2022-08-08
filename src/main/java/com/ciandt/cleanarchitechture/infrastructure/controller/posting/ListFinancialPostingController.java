package com.ciandt.cleanarchitechture.infrastructure.controller.posting;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.application.usecase.posting.list.ListFinancialPostingInput;
import com.ciandt.cleanarchitechture.application.usecase.posting.list.ListFinancialPostingUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/post/list")
public class ListFinancialPostingController {

    @Autowired
    ListFinancialPostingUseCase listFinancialPostingUseCase;

    @PostMapping
    public ResponseEntity<Page<FinancialPostingOutput>> listFinancialPostings(@RequestBody @Valid ListFinancialPostingInput form) {
        Pageable pageable = PageRequest.of(0, 50);
        Page<FinancialPostingOutput> postings = listFinancialPostingUseCase.execute(form, pageable);
        if (postings == null || postings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok().body(postings);
    }

}
