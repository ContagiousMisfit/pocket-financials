package com.ciandt.cleanarchitechture.application.usecase.posting.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class ListFinancialPostingInput {

    private Long postingTypeId;

    private LocalDate startingDate;

    private LocalDate endingDate;

}
