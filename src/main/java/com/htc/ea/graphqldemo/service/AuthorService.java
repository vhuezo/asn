package com.htc.ea.graphqldemo.service;

import java.util.List;
import java.util.Optional;

import com.htc.ea.graphqldemo.domain.model.Author;

public interface AuthorService {

	public Optional<Author> getAuthor(int authorId);
	public Author saveAuthor(Author author); 
	public List<Author> getAllAuthor();
	
}