package com.ciandt.cleanarchitechture.infrastructure.repository;

import com.ciandt.cleanarchitechture.domain.entity.PostingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingTypeRepository extends JpaRepository<PostingType, Long> {
}
