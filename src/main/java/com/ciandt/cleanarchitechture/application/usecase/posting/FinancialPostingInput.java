package com.ciandt.cleanarchitechture.application.usecase.posting;

import com.ciandt.cleanarchitechture.domain.entity.PostingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class FinancialPostingInput {

    private PostingType postingType;

    private LocalDate startingDate;

    private LocalDate endingDate;

}
