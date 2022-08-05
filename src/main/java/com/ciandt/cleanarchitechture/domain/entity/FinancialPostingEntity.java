package com.ciandt.cleanarchitechture.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "financial_posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialPostingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(name = "active", nullable = false)
    private boolean isActive;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private PostingType type;

}
