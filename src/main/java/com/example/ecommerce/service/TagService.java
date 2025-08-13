package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.repository.TagRepository;
import com.example.ecommerce.model.Tag;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	
	//Create
	public Tag CreateTag(Tag tag) {
		return tagRepository.save(tag);
	}
	
	//Read
	public List<Tag> getAllTag() {
		return tagRepository.findAll();
	}
	
	//Read by ID
	public List<Tag> ReadByID(List<Long> tagIds) {
		//if(tagRepository.existsById(tagIds) == true) {
			//return tagRepository.findById(tagIds).get();
			return tagRepository.findAllById(tagIds);
		//}
		//return new Tag();
		////return tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Tag not found"));
	}
	
	//Update
	public String UpdateTag(Long id, Tag tag) {
		
		if(tagRepository.existsById(id) == true) {
			Tag TagFound = tagRepository.getById(id);
			TagFound.setName(tag.getName());
			tagRepository.save(tag);
			return "Tag updated successfully";
		}
		return "Tag not found";
	}
	
	//Delete
	public String DeleteTag(Long id) {
		
		if(tagRepository.existsById(id) == true) {
			tagRepository.deleteById(id);
			return "Tag delete successfully";
		}
		
		return "Tag not found";
	}
	
	
}
