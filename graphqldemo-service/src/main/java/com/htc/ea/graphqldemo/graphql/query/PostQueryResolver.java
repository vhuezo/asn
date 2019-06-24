package com.htc.ea.graphqldemo.graphql.query;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.htc.ea.graphqldemo.builder.BuilderData;
import com.htc.ea.graphqldemo.domain.dto.AuthorDto;
import com.htc.ea.graphqldemo.domain.dto.PostDto;
import com.htc.ea.graphqldemo.domain.model.Post;
import com.htc.ea.graphqldemo.service.PostService;

@Component
public class PostQueryResolver implements GraphQLQueryResolver {

	private static final Logger logger = LoggerFactory.getLogger(PostQueryResolver.class);

	@Autowired
	private PostService postService;

	public List<PostDto> recentPosts(int count, int offset) {
		List<Post> posts = postService.getRecentPosts(count, offset);
		logger.info("Post recientes encontrados: {}", posts.size());
		List<PostDto> postList = new ArrayList<>();
		posts.forEach(post -> {
			postList.add(BuilderData.fillPostDto(post));
		});
		return postList;
	}

	public List<PostDto> getPosts(AuthorDto author) {
		List<Post> posts = postService.getAuthorPosts(BuilderData.fillAuthor(author));
		logger.info("Post encontrados: {}", posts.size());
		List<PostDto> postDto = new ArrayList<>();
		posts.forEach(post -> {
			postDto.add(BuilderData.fillPostDto(post));			
		});
		return postDto;
	}
}