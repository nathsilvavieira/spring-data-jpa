package com.springdata.idgenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {
	
	//@TableGenerator(name = "employee_gen",table="id_gen",pkColumnName="gen_name",valueColumnName="gen_val",allocationSize=100)	
	@GenericGenerator(name="emp_id",strategy="com.springdata.idgenerators.CustomRandomIdGenerator")
	@Id
	@GeneratedValue(generator="emp_id")
	//@GeneratedValue(strategy=GenerationType.TABLE,generator="employee_gen")
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
