package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee save(Employee employee) {
		return repository.save(employee);
	}
	
	public Iterable show(){
		return repository.findAll();
	}
	
	public Optional findById(int id) {
		return repository.findById(id);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
	

	
}
