package com.htc.ea.graphqldemo.builder;

import com.htc.ea.graphqldemo.domain.dto.AuthorDto;
import com.htc.ea.graphqldemo.domain.dto.PostDto;
import com.htc.ea.graphqldemo.domain.model.Author;
import com.htc.ea.graphqldemo.domain.model.Post;

public final class BuilderData {

	public static PostDto fillPostDto(Post post) {
		PostDto data = new PostDto();
		data.setAuthor(fillAuthorDto(post.getAuthorId()));
		data.setCategory(post.getCategory());
		data.setId(post.getId());
		data.setText(post.getText());
		data.setTitle(post.getTitle());
		return data;
	}
	
	public static Post fillPost(PostDto post) {
		Post data = new Post();
		data.setAuthorId(fillAuthor(post.getAuthor()));
		data.setCategory(post.getCategory());
		data.setId(post.getId());
		data.setText(post.getText());
		data.setTitle(post.getTitle());
		return data;
	}
	
	public static Author fillAuthor(AuthorDto author) {
		Author data = new Author();
		data.setId(author.getId());
		data.setName(author.getName());
//		author.getPost().forEach(postDto -> {			
//			data.getPostList().add(fillPost(postDto));
//		});
		data.setThumbnail(author.getThumbnail());
		return data;
	}
	
	public static AuthorDto fillAuthorDto(Author author) {
		AuthorDto data = new AuthorDto();
		data.setId(author.getId());
		data.setName(author.getName());
		data.setPostQty(author.getPostList().size());
		data.setThumbnail(author.getThumbnail());
		return data;
	}
}