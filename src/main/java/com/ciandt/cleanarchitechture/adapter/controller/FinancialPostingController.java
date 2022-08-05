package com.ciandt.cleanarchitechture.adapter.controller;

import com.ciandt.cleanarchitechture.adapter.controller.dto.PostingDto;
import com.ciandt.cleanarchitechture.adapter.controller.form.FinancialPostingForm;
import com.ciandt.cleanarchitechture.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.usecase.FinancialPostingService;
import com.ciandt.cleanarchitechture.usecase.FinancialPostingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<Page<PostingDto>> listFinancialPostings(@RequestBody @Valid FinancialPostingForm form) {
        Pageable pageable = PageRequest.of(0, 50);
        Page<FinancialPostingEntity> financialPostingEntities = financialPostingService.getPostingByTypeOrPeriod(form, pageable);
        Page<PostingDto> postingDtos = PostingDto.convert(financialPostingEntities);
        return ResponseEntity.ok().body(postingDtos);
    }

}
