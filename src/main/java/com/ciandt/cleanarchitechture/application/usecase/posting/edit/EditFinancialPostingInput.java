package com.ciandt.cleanarchitechture.application.usecase.posting.edit;

import com.ciandt.cleanarchitechture.domain.entity.FinancialPostingEntity;
import com.ciandt.cleanarchitechture.domain.entity.PostingType;
import com.ciandt.cleanarchitechture.domain.entity.UserEntity;
import com.ciandt.cleanarchitechture.infrastructure.repository.PostingTypeRepository;
import com.ciandt.cleanarchitechture.infrastructure.repository.UserRepository;
import lombok.Getter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Getter
public class EditFinancialPostingInput {

    private LocalDate date;

    @NotNull
    @Size(max = 100)
    private String description;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal value;

    private boolean isActive;

    private Long userId;

    private Long postingTypeId;

    public EditFinancialPostingInput(LocalDate date, String description, BigDecimal value, boolean isActive, Long userId, Long postingTypeId) {
        this.date = LocalDate.now();
        this.description = description;
        this.value = value;
        this.isActive = true;
        this.userId = userId;
        this.postingTypeId = postingTypeId;
    }

    public FinancialPostingEntity edit(PostingTypeRepository postingTypeRepository, UserRepository userRepository) {
        Optional<UserEntity> user = userRepository.findById(userId);
        Optional<PostingType> postingType = postingTypeRepository.findById(postingTypeId);

        if (user == null || postingType == null)
            throw new IllegalArgumentException();

        return new FinancialPostingEntity()
                .builder()
                .date(date)
                .description(description)
                .value(value)
                .isActive(isActive)
                .user(user.get())
                .type(postingType.get())
                .build();
    }

}
