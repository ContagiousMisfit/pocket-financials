package com.ciandt.cleanarchitechture.application.usecase.posting.list;

import com.ciandt.cleanarchitechture.domain.entity.PostingType;
import com.ciandt.cleanarchitechture.infrastructure.repository.PostingTypeRepository;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class SearchParamsDto {

    private PostingType postingType;

    private LocalDate startDate;

    private LocalDate endDate;

    public static SearchParamsDto convert(ListFinancialPostingInput form, PostingTypeRepository postingTypeRepository) {

        if (form.getPostingTypeId() == null)
            form.setPostingTypeId(4L);

        if (form.getStartingDate() == null)
            form.setStartingDate(LocalDate.now().minusYears(2));

        if (form.getEndingDate() == null)
            form.setEndingDate(LocalDate.now().minusYears(1));

        return SearchParamsDto
                .builder()
                .postingType(postingTypeRepository.findById(form.getPostingTypeId()).get())
                .startDate(form.getStartingDate())
                .endDate(form.getEndingDate())
                .build();

    }
}
