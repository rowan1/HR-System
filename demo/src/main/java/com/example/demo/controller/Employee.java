package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class Employee {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity show() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
