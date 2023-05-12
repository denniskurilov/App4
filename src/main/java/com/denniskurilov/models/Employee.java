package com.denniskurilov.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Employee { 
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "first_name")
    @NotEmpty(message = "should be not empty")
	@Size(min = 1, max = 30, message = "Size should be between 1 and 30 chars")
	private String firstName;
	
    @Column(name = "last_name")
	@NotEmpty(message = "should be not empty")
	@Size(min = 1, max = 30, message = "Size should be between 1 and 30 chars")
	private String lastName;
	
	@Min(value = 1, message = "Age should be greate then 0")
	private long age;
	
	@NotEmpty(message = "should be not empty")
	@Email(message = "should be valid")
	private String email;
	
	public Employee(long id) {
		super();
		this.id = id;
		this.firstName = "";
		this.lastName = "";
		this.age = 0;
		this.email = "";
	}
	
	public Employee() {
		super();
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.age = 0;
		this.email = "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getName() {
		return firstName + " " + lastName;
	}
	
}
