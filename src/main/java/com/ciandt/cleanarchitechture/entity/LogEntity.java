package com.ciandt.cleanarchitechture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate actionDate;

    private String action;

    @ManyToOne
    private UserEntity user;

}
