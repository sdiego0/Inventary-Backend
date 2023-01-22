package com.conpany.inventary.services;

import org.springframework.http.ResponseEntity;

import com.conpany.inventary.model.Category;
import com.conpany.inventary.response.CategoryResponseRest;

public interface ICategoryService {

	public ResponseEntity<CategoryResponseRest>search();
	public ResponseEntity<CategoryResponseRest>searchById(Long id);
	public ResponseEntity<CategoryResponseRest>save(Category category);
	public ResponseEntity<CategoryResponseRest>update(Category category,Long id);
	public ResponseEntity<CategoryResponseRest>delete(Long id);
}
