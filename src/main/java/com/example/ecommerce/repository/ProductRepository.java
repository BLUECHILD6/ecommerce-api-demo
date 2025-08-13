//package com.example.ecommerce;
package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Product;

// repository will get all the function from JpaRespository
// the 1st argument inside <> will be your entity name
// the 2nd argument inside <> will be the ID data type
// the theory term is Generic ( can refer to to as reference)
public interface ProductRepository extends JpaRepository<Product, Long> {
	//it will know going to open up select * from product where name like ''
	List<Product> findByName(String name);
	
	//it will be mapped to select * from product where price <= 100
	List<Product> findByPriceLessThanEqual(double price);
}
