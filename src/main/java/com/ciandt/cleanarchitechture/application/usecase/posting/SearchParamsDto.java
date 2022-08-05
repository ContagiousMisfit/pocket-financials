package com.ciandt.cleanarchitechture.application.usecase.posting;

import com.ciandt.cleanarchitechture.domain.entity.PostingType;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class SearchParamsDto {

    private PostingType postingType;

    private LocalDate startDate;

    private LocalDate endDate;

    public SearchParamsDto convert(FinancialPostingInput form) {

        if (form.getPostingType() == null)
            form.setPostingType(PostingType.builder().id(4L).name("All Types").build());

        if (form.getStartingDate() == null)
            form.setStartingDate(LocalDate.now().minusYears(1));

        if (form.getEndingDate() == null)
            form.setEndingDate(LocalDate.now());

        return SearchParamsDto
                .builder()
                .postingType(form.getPostingType())
                .startDate(form.getStartingDate())
                .endDate(form.getEndingDate())
                .build();

    }
}
