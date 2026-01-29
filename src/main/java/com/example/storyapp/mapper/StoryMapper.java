package com.example.storyapp.mapper;

import com.example.storyapp.dto.StoryDTO;
import com.example.storyapp.model.Story;
import com.example.storyapp.repository.StoryRepository;

public class StoryMapper {
	public static StoryDTO toDTO(Story story){
		return new StoryDTO(
				story.getId(),
				story.getTitle(),
				story.getContent(),
				story.getAuther()
		);
	}
	
	public static Story toEntity(StoryDTO dto){
		Story story=new Story();
		story.setTitle(dto.getTitle());
	}
}
