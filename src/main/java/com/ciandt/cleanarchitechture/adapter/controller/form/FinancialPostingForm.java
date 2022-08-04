package com.ciandt.cleanarchitechture.adapter.controller.form;

import com.ciandt.cleanarchitechture.entity.PostingTypeEntity;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class FinancialPostingForm {

    private PostingTypeEntity postingTypeEntity;

    private LocalDate firstDateFromFilterRange;

    private LocalDate lastDateFromFilterRange;

}
