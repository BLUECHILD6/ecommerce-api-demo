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

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return categoryService.CreateCategory(category);
	}
	
	@GetMapping
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}
	
	@GetMapping("/{ID}")
	public Category getCategoryByID(@PathVariable Long ID) {
		return categoryService.ReadByID(ID);
	}
	
	@DeleteMapping("/{ID}")
	public String deleteCategory(@PathVariable Long ID) {
		return categoryService.DeleteCategory(ID);
	}
	
	@PutMapping("/{ID}")
	public String updateCategory(@PathVariable Long ID, @RequestBody Category UpdateCategory) {
		return categoryService.UpdateCategory(ID, UpdateCategory);
	}
}
