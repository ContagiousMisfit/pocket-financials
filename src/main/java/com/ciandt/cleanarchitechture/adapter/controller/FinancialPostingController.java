package com.ciandt.cleanarchitechture.adapter.controller;

import com.ciandt.cleanarchitechture.adapter.controller.dto.PostingDto;
import com.ciandt.cleanarchitechture.adapter.controller.form.FinancialPostingForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/post")
public class FinancialPostingController {

    @PostMapping
    public ResponseEntity<PostingDto> listFinancialPostings(@RequestBody @Valid FinancialPostingForm form) {
        return null;
    }

}
