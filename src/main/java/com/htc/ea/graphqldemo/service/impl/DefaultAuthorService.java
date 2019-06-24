package com.htc.ea.graphqldemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.ea.graphqldemo.domain.model.Author;
import com.htc.ea.graphqldemo.domain.repository.AuthorRepository;
import com.htc.ea.graphqldemo.service.AuthorService;

@Service
public class DefaultAuthorService implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public Optional<Author> getAuthor(int authorId) {
		return authorRepository.findById(authorId);
	}
	
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public List<Author> getAllAuthor() {
		return authorRepository.findAll();
	}
}