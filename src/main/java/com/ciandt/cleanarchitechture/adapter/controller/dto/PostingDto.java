package com.ciandt.cleanarchitechture.adapter.controller.dto;

import com.ciandt.cleanarchitechture.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.entity.PostingTypeEntity;
import com.ciandt.cleanarchitechture.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PostingDto {

    private Long id;

    private LocalDate date;

    private String description;

    private BigDecimal value;

    private boolean isActive;

    private UserEntity user;

    private PostingTypeEntity type;

    public PostingDto(FinancialPostingEntity financialPostingEntity) {
        this.id = financialPostingEntity.getId();
        this.date = financialPostingEntity.getDate();
        this.description = financialPostingEntity.getDescription();
        this.value = financialPostingEntity.getValue();
        this.isActive = financialPostingEntity.isActive();
        this.user = financialPostingEntity.getUser();
        this.type = financialPostingEntity.getType();
    }
    public static Page<PostingDto> convert(Page<FinancialPostingEntity> financialPostingEntities) {
        return financialPostingEntities.map(PostingDto::new);
    }
}
