package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.Tag;
import com.example.ecommerce.service.TagService;

@RestController
@RequestMapping("/api/tags")
public class TagController {
	@Autowired
	private TagService tagService;
	
	@PostMapping
	public Tag addTag(@RequestBody Tag tag) {
		return tagService.CreateTag(tag);
	}
	
	@GetMapping
	public List<Tag> getAllTag() {
		return tagService.getAllTag();
	}
	
//	@GetMapping("/{ID}")
//	public Tag getTagByID(@PathVariable Long ID) {
//		//return tagService.ReadByID(ID);
//		Tag BlankTag = new Tag();
//		return BlankTag;
//	}
	
	@DeleteMapping("/{ID}")
	public String deleteTag(@PathVariable Long ID) {
		return tagService.DeleteTag(ID);
	}
	
	@PutMapping("/{ID}")
	public String updateTag(@PathVariable Long ID, @RequestBody Tag UpdateTag) {
		return tagService.UpdateTag(ID, UpdateTag);
	}
}
