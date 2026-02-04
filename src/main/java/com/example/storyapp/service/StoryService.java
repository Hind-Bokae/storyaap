package com.example.storyapp.service;

import com.example.storyapp.model.Story;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StoryService {
	Story createStory(Story story);
	List<Story> getAllStories();
	Story getStoryById(Long id);
	Story updateStoryById(Long id, Story story);
	void deleteStory(Story story);
	Page<Story> searchStories(String searchTerm, Pageable pageable);
	
}
