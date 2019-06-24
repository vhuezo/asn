package com.htc.ea.graphqldemo.graphql.query;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.htc.ea.graphqldemo.builder.BuilderData;
import com.htc.ea.graphqldemo.domain.dto.AuthorDto;
import com.htc.ea.graphqldemo.domain.model.Author;
import com.htc.ea.graphqldemo.service.AuthorService;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {

	private static final Logger logger = LoggerFactory.getLogger(AuthorQueryResolver.class);
	
	@Autowired
	private AuthorService authorService;
	
	public Optional<AuthorDto> getAuthor(int id) {
		Optional<Author> author = authorService.getAuthor(id);
		if (author.isPresent()) {
			logger.info("Author encontrado: {}", author.get());
			return Optional.of(BuilderData.fillAuthorDto(author.get()));
		} else 
			return null;
	}
}