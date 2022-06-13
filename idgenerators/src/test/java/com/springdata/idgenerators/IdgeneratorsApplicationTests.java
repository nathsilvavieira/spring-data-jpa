package com.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class IdgeneratorsApplicationTests {
	
	@Autowired
	EmployeeRepository repository;

	
	@Test
	public void testCreate() {
		Employee emp = new Employee();
		emp.setName("Rafa");
		repository.save(emp);
	}
	
	@Test
	public void testCreate2() {
		Employee emp2 = new Employee();
		emp2.setName("Abe");
		repository.save(emp2);
	}


}

