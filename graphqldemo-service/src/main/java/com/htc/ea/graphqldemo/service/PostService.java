package com.htc.ea.graphqldemo.service;

import java.util.List;

import com.htc.ea.graphqldemo.domain.model.Author;
import com.htc.ea.graphqldemo.domain.model.Post;

public interface PostService {

	 public List<Post> getRecentPosts(int count, int offset);
	 public List<Post> getAuthorPosts(Author author);
	 public Post newPost(Post post);	 
}