package com.example.ecommerce.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagService;
	
	//Create
	public Product CreateProduct(Product product, Long CategoryId, List<Long> tagIds) {
		product.setCategory(categoryService.ReadByID(CategoryId));
		product.setTags(Set.copyOf(tagService.ReadByID(tagIds)));
		return productRepository.save(product);
	}
	
	//Read
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	//Read by ID
	public Product ReadByID(Long id) {
		if(productRepository.existsById(id) == true) {
			return productRepository.findById(id).get();
		}
		Product BlankProd = new Product();
		BlankProd.setId(0L);
		BlankProd.setName(null);
		BlankProd.setDescription(null);
		BlankProd.setPrice(null);
		BlankProd.setQuantity(0);
		return BlankProd;
		//return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	//Update
	public String UpdateProduct(Long id, Product product) {
		
		if(productRepository.existsById(id) == true) {
			Product ProdFound = productRepository.getById(id);
			ProdFound.setName(product.getName());
			ProdFound.setDescription(product.getDescription());
			ProdFound.setQuantity(product.getQuantity());
			ProdFound.setPrice(product.getPrice());
			productRepository.save(ProdFound);
			return "Product updated successfully";
		}
		return "Product not found";
	}
	
	//Delete
	public String DeleteProduct(Long id) {
		
		if(productRepository.existsById(id) == true) {
			productRepository.deleteById(id);
			return "Product delete successfully";
		}
		
		return "Product not found";
	}
	
	
}
