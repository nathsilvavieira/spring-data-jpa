package com.springdata;


import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	
	List<Product> findByDescContains(String desc);

	List<Product> findByNameAndDesc(String name,String desc);
	
	List<Product> findByPriceGreaterThan(Double price);
	
	List<Product> findByPriceBetween(Double price1, Double price2 );
	
}
