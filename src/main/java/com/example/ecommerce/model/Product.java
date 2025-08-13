package com.example.ecommerce.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

//Entity the java class/bean that will be mapped to the database usage
//ORM = object relational mapping
//object = class, property, methods
//relational = table, query
//mapping 

//entity require class name (table name), id(primary key, column name), property(column)
// **Entity name and ID data type

//Repository - interface that open up to run the query on the table (methods to run the database operation)

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment and unique
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id") //foreign key
	//whenever I load my product in API, do not include the category
	@JsonBackReference
	private Category category;
	
	//defining many to many relation
	//there will be and additional table created, which is called product_tag
	//inside product_tag, there will two column - product_id, tag_id => pivot table 
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		    name = "product_tag",
		    joinColumns = @JoinColumn(name = "product_id"),
		    inverseJoinColumns = @JoinColumn(name = "tag_id")
		)
	private Set<Tag> tags;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	
	
	
	
	
	
}
