package com.denniskurilov.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	@Transactional
	public List<Employee> getAll() {
		return employeeRepository.getAll();
	}

	@Override
	@Transactional
	public List<Employee> search(String keyword) {
		return employeeRepository.search(keyword);
	}
	
	@Override
	@Transactional
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public Employee get(long id) {
		return employeeRepository.get(id);
	}

	@Override
	@Transactional
	public void delete(Employee employee) {
		employeeRepository.delete(employee);
	}

}