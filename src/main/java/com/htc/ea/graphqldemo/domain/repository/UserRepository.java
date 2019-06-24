package com.htc.ea.graphqldemo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.ea.graphqldemo.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}