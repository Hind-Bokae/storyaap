package com.example.storyapp.service;

import com.example.storyapp.model.Story;

import java.util.List;

public interface StoryService {
	Story createStory(Story story);
	List<Story> getAllStories();
	Story getStoryById(Long id);
	void deleteStory(Story story);
}
