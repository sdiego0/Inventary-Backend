package com.conpany.inventary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conpany.inventary.response.CategoryResponseRest;
import com.conpany.inventary.services.CategoryServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest>searchCategories(){
		ResponseEntity<CategoryResponseRest>response = categoryServiceImpl.search();
		return response;
	}
}
