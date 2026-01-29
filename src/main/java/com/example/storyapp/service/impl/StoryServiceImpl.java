package com.example.storyapp.service.impl;

import com.example.storyapp.model.Story;
import com.example.storyapp.repository.StoryRepository;
import com.example.storyapp.service.StoryService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {
	private final StoryRepository storyRepository;
	public StoryServiceImpl(StoryRepository storyRepository){
		this.storyRepository=storyRepository;
	}
	@Override
	public Story createStory(Story story){
		return storyRepository.save(story);
	}
	 @Override
	public List<Story>getAllStories(){
		return storyRepository.findAll();
	 }
	 
	 @Override
	public Story getStoryById(Long id){
		return storyRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Story not found"));
	 }
	 @Override
	public void deleteStory(Story story){
		storyRepository.delete(story);
	 }
}
