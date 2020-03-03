package com.example.demo.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired 
	private EmployeeService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity show() {
		Iterable<Employee> iter = service.show();
		
		return new ResponseEntity<>(iter, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public ResponseEntity show(@PathVariable int id) {
		
		Optional optional = service.findById(id);
        return optional.isPresent()? new ResponseEntity<>(optional.get(), HttpStatus.OK):
        	new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity create(@RequestBody Employee employee) {
		Employee model = service.save(employee);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity update(@RequestBody Employee employee) {
		Employee model = service.save(employee);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable int id) {
		if(service.findById(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
    }
	
	@RequestMapping( method = RequestMethod.DELETE)
	public ResponseEntity delete() {
		service.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
    }
}
