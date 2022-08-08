package com.ciandt.cleanarchitechture.infrastructure.repository;

import com.ciandt.cleanarchitechture.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
