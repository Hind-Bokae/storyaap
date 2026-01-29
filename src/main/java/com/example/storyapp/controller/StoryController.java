package com.example.storyapp.controller;

import com.example.storyapp.dto.StoryDTO;
import com.example.storyapp.mapper.StoryMapper;
import com.example.storyapp.model.Story;
import com.example.storyapp.service.StoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stories")
public class StoryController {
	private final StoryService storyService;
	public StoryController(StoryService storyService){
		this.storyService=storyService;
	}
	@PostMapping
	public StoryDTO createStory(@Valid @RequestBody StoryDTO dto){
		Story story = StoryMapper.toEntity(dto);
		Story savedStory=storyService.createStory(story);
		return StoryMapper.toDTO(savedStory);
	}
	@GetMapping
	public List<StoryDTO> getAllStories(){
		return storyService.getAllStories().stream().map(StoryMapper::toDTO).toList();
	}
	@GetMapping("/{id}")
	public StoryDTO getStoryById(@PathVariable Long id){
		Story story =storyService.getStoryById(id);
		return StoryMapper.toDTO(story);
	}
	@PutMapping("/{id}")
	public StoryDTO updateStory(@PathVariable Long id,@Valid @RequestBody StoryDTO dto){
		Story story=storyService.getStoryById(id);
		story.setTitle(dto.getTitle());
		story.setContent(dto.getContent());
		story.setAuther(dto.getAuthor());
		Story updatedStory = storyService.createStory(story);
		return StoryMapper.toDTO(updatedStory);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStory(@PathVariable Long id){
		Story story = storyService.getStoryById(id);
		storyService.deleteStory(story);
	}
}
