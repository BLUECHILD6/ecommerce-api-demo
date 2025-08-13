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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//test flow
	//1. create a product post localhost:8080/api/product?categoryId=1
	//2. get all product or get by id
	//3. get all category or by id
	@PostMapping
	public Product addProduct(@RequestBody Product product, @RequestParam Long categoryId, @RequestParam List<Long> TagIds) {
		return productService.CreateProduct(product, categoryId, TagIds);
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProduct();
	}
	
	@GetMapping("/{ID}")
	public Product getProductByID(@PathVariable Long ID) {
		return productService.ReadByID(ID);
	}
	
	@DeleteMapping("/{ID}")
	public String deleteProduct(@PathVariable Long ID) {
		return productService.DeleteProduct(ID);
	}
	
	@PutMapping("/{ID}")
	public String updateProduct(@PathVariable Long ID, @RequestBody Product UpdateProduct) {
		return productService.UpdateProduct(ID, UpdateProduct);
	}
}
