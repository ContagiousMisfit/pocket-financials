package com.ciandt.cleanarchitechture.entity;

import javax.persistence.Table;

@Table(name = "types")
public enum PostingTypeEntity {

    INCOME, OUTCOME, INVESTMENT, ALL_TYPES;

}
