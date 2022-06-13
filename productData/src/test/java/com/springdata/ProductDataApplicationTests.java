package com.springdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductDataApplicationTests {
	
	@Autowired
	ProductRepository repository;

	@Test
	void contextLoads() {
		testCreate();
		testCount();
		testRead();
		testUpdate();
		testDelete();
	}
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Awesome");
		product.setPrice(1000);
		
		repository.save(product);
	}
	
	@Test
	public void testRead() {
		Product product = repository.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone",product.getName());
		System.out.println(">>>>>>" + product.getDesc());
	}
	
	@Test
	public void testUpdate() {
		Product product = repository.findById(1).get();
		product.setPrice(1200d);
		repository.save(product);
	}
	
	@Test
	public void testDelete() {
		if(repository.existsById(1)){
		repository.deleteById(1);
		}
	}
	
	@Test
	public void testCount(){
		System.out.println("Total Records >>> "+repository.count());
	}
	
	@Test
	public void testFindByName() {
		List<Product> products = repository.findByName("Airpods");
		products.forEach((p)-> System.out.println("Value of Airpods $"+p.getPrice()) );
		
	}
	
	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = repository.findByNameAndDesc("MacBook","Notebook from Apple");
		products.forEach((p)-> System.out.println("Value of MacBook $"+p.getPrice()) );
	}
	
	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = repository.findByPriceGreaterThan(150d);
		products.forEach((p)-> System.out.println("Product "+ p.getName() +" Value $ "+p.getPrice()+", ") );
	}
	
	@Test
	public void testFindByDescContains() {
		List<Product> products = repository.findByDescContains("Notebook from Apple");
		products.forEach((p)-> System.out.println("Value of produt contais $"+p.getPrice()) );
		
	}
	
	@Test
	public void testFindByPriceBetween() {
		List<Product> products = repository.findByPriceBetween(1000d,5000d);
		products.forEach((p)-> System.out.println("Between two prices, Product "+ p.getName() +" Value $ "+p.getPrice()+", ") );
	}
	
}
