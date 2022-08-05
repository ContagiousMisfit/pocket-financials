package com.ciandt.cleanarchitechture.infrastructure.controller.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FormErrorDto {

    private String field;
    private String error;

}
