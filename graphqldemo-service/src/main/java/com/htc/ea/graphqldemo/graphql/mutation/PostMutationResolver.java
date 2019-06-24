package com.htc.ea.graphqldemo.graphql.mutation;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.htc.ea.graphqldemo.builder.BuilderData;
import com.htc.ea.graphqldemo.domain.dto.PostDto;
import com.htc.ea.graphqldemo.domain.model.Author;
import com.htc.ea.graphqldemo.domain.model.Post;
import com.htc.ea.graphqldemo.service.AuthorService;
import com.htc.ea.graphqldemo.service.PostService;

@Component
public class PostMutationResolver implements GraphQLMutationResolver {

	private static final Logger logger = LoggerFactory.getLogger(PostMutationResolver.class);

	@Autowired
	private PostService postService;
	@Autowired
	private AuthorService authorService;

	public PostDto writePost(String title, String text, String category, int authorId) {
		Post post = new Post();
		post.setTitle(title);
		post.setText(text);
		post.setCategory(category);
		Optional<Author> authorFound = authorService.getAuthor(authorId);
		if (authorFound.isPresent()) {
			post.setAuthorId(authorFound.get());			
			boolean saved = postService.newPost(post) != null;
			logger.info("Post, {} {}", (saved ? "creado exitosamente" : "hubo un error en la creación"), post);
			PostDto postDto = BuilderData.fillPostDto(post);		
			return postDto;
		} else {
			logger.error("Hubo un error en la creación del Post con authorId: {}, no encontrado", authorId);
			return null;		
		}
	}
}