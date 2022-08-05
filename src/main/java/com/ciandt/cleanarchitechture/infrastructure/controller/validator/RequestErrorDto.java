package com.ciandt.cleanarchitechture.infrastructure.controller.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RequestErrorDto {

    private String field;
    private String error;

}
