package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.model.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	//Create
	public Category CreateCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	//Read
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}
	
	//Read by ID
	public Category ReadByID(Long id) {
		if(categoryRepository.existsById(id) == true) {
			return categoryRepository.findById(id).get();
		}
		//return null;
		return new Category();
		//the safe way to indicate that the return data type can either be category or null
		//return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
	}
	
	//Update
	public String UpdateCategory(Long id, Category category) {
		
		if(categoryRepository.existsById(id) == true) {
			Category CatFound = categoryRepository.getById(id);
			CatFound.setName(category.getName());
			categoryRepository.save(category);
			return "Category updated successfully";
		}
		return "Category not found";
	}
	
	//Delete
	public String DeleteCategory(Long id) {
		
		if(categoryRepository.existsById(id) == true) {
			categoryRepository.deleteById(id);
			return "Category delete successfully";
		}
		
		return "Category not found";
	}
	
	
}
