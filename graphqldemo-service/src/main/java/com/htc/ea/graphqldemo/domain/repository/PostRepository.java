package com.htc.ea.graphqldemo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.ea.graphqldemo.domain.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}