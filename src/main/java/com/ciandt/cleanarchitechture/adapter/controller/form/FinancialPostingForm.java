package com.ciandt.cleanarchitechture.adapter.controller.form;

import com.ciandt.cleanarchitechture.entity.PostingTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class FinancialPostingForm {

    private PostingTypeEntity postingTypeEntity;

    private LocalDate startingDate;

    private LocalDate endingDate;

}
