package com.twentyone.termgame.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twentyone.termgame.user.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByUsername(String username);
  Optional<UserEntity> findByPhoneNumber(String phoneNumber);
  boolean existsByUsername(String username);
  boolean existsByPhoneNumber(String phoneNumber);
}
