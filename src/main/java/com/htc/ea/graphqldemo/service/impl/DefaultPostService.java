package com.htc.ea.graphqldemo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.ea.graphqldemo.domain.model.Author;
import com.htc.ea.graphqldemo.domain.model.Post;
import com.htc.ea.graphqldemo.domain.repository.PostRepository;
import com.htc.ea.graphqldemo.service.PostService;
	
@Service
public class DefaultPostService implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> getRecentPosts(int count, int offset) {		
		return postRepository.findAll().stream().skip(offset).limit(count).collect(Collectors.toList());
	}

	@Override
	public List<Post> getAuthorPosts(Author author) {
		return postRepository.findAll().stream().filter(post -> author.getId()==post.getAuthorId().getId()).collect(Collectors.toList());
	}
	
	@Override
	public Post newPost(Post post) {
		return postRepository.save(post);
	}
}