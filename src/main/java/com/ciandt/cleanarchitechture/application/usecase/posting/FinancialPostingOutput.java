package com.ciandt.cleanarchitechture.application.usecase.posting;

import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.domain.entity.PostingType;
import com.ciandt.cleanarchitechture.domain.entity.UserEntity;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class FinancialPostingOutput {

    private Long id;

    private LocalDate date;

    private String description;

    private BigDecimal value;

    private boolean isActive;

    private UserEntity user;

    private PostingType type;

    public FinancialPostingOutput(FinancialPostingEntity financialPostingEntity) {
        this.id = financialPostingEntity.getId();
        this.date = financialPostingEntity.getDate();
        this.description = financialPostingEntity.getDescription();
        this.value = financialPostingEntity.getValue();
        this.isActive = financialPostingEntity.isActive();
        this.user = financialPostingEntity.getUser();
        this.type = financialPostingEntity.getType();
    }

    public static Page<FinancialPostingOutput> convertToPage(Page<FinancialPostingEntity> financialPostingEntities) {
        return financialPostingEntities.map(FinancialPostingOutput::new);
    }

}
