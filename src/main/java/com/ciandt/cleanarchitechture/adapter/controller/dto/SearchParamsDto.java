package com.ciandt.cleanarchitechture.adapter.controller.dto;

import com.ciandt.cleanarchitechture.adapter.controller.form.FinancialPostingForm;
import com.ciandt.cleanarchitechture.entity.PostingTypeEntity;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class SearchParamsDto {

    private PostingTypeEntity postingTypeEntity;

    private LocalDate startDate;

    private LocalDate endDate;

    public SearchParamsDto converter(FinancialPostingForm form) {

        if (form.getPostingTypeEntity() == null)
            form.setPostingTypeEntity(PostingTypeEntity.ALL_TYPES);

        if (form.getStartingDate() == null)
            form.setStartingDate(LocalDate.now().minusYears(1));

        if (form.getEndingDate() == null)
            form.setEndingDate(LocalDate.now());

        return SearchParamsDto
                .builder()
                .postingTypeEntity(form.getPostingTypeEntity())
                .startDate(form.getStartingDate())
                .endDate(form.getEndingDate())
                .build();

    }
}
