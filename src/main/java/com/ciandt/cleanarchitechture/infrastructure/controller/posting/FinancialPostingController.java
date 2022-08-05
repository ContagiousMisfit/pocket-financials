package com.ciandt.cleanarchitechture.infrastructure.controller.posting;

import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingOutput;
import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingInput;
import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.application.usecase.posting.FinancialPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/post")
public class FinancialPostingController {

    @Autowired
    FinancialPostingService financialPostingService;

    @PostMapping
    public ResponseEntity<Page<FinancialPostingOutput>> listFinancialPostings(@RequestBody @Valid FinancialPostingInput form) {
        Pageable pageable = PageRequest.of(0, 50);
        Page<FinancialPostingEntity> financialPostingEntities = financialPostingService.getPostingByTypeOrPeriod(form, pageable);
        Page<FinancialPostingOutput> postingDtos = FinancialPostingOutput.convert(financialPostingEntities);
        return ResponseEntity.ok().body(postingDtos);
    }

}
