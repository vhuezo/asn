package com.htc.ea.graphqldemo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.ea.graphqldemo.domain.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}