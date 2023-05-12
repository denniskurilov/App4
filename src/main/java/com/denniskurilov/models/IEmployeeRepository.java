package com.denniskurilov.models;

import java.util.List;

public interface IEmployeeRepository {

	public List<Employee> getAll();

	public List<Employee> search(String keyword);

	public void save(Employee employee);

	public Employee get(long id);

	public void delete(Employee employee);
}
