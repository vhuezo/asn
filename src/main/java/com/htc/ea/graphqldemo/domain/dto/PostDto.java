package com.htc.ea.graphqldemo.domain.dto;

public class PostDto {

	private int id;
	private String title;
	private String text;
	private String category;
	private AuthorDto author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostDto [id=").append(id).append(", title=").append(title).append(", text=").append(text)
				.append(", category=").append(category).append(", author=").append(author).append("]");
		return builder.toString();
	}
}