package com.htc.ea.graphqldemo.domain.dto;

public class AuthorDto {
	
	private int id;
	private String name;
	private String thumbnail;
	private int postQty;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public int getPostQty() {
		return postQty;
	}

	public void setPostQty(int postQty) {
		this.postQty = postQty;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthorDto [id=").append(id).append(", name=").append(name).append(", thumbnail=")
				.append(thumbnail).append(", postQty=").append(postQty).append("]");
		return builder.toString();
	}
}