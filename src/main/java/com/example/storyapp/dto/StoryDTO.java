package com.example.storyapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.support.PageableUtils;

public class StoryDTO {
	//region 1. Attribute
	private Long id;
	@NotBlank(message="Title is required")
	@Size(min=3, max = 100, message = "Title must be between 3 and 100 characters")
	private String title;
	@NotBlank(message = "Content is required")
	@Size(min = 10, message = "Content must be at least 10 characters long")
	private String content;
	@NotBlank(message = "Author is required")
	private String author;
	//endregion
	//region 2.Constructors
	public StoryDTO(){}
	
	public StoryDTO(Long id,String title,String content,String author){
		this.id=id;
		this.title=title;
		this.content=content;
		this.author=author;
	}
	//endregion
	//region 3.Getter & Setter
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){ this.title=title;}
	
	public String getContent(){return content;}
	public void setContent(String content){this.content=content;}
	
	public String getAuthor(){return author;}
	public void setAuthor(String author){this.author=author;}
}
