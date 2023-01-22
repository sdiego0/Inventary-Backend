package com.conpany.inventary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conpany.inventary.model.Category;
import com.conpany.inventary.response.CategoryResponseRest;
import com.conpany.inventary.services.CategoryServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	/**get all categories**/
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest>searchCategories(){
		ResponseEntity<CategoryResponseRest>response = categoryServiceImpl.search();
		return response;
	}
	
	/**get category by id**/
	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryResponseRest>searchCategoryById(@PathVariable("id")Long id){
		ResponseEntity<CategoryResponseRest>response = categoryServiceImpl.searchById(id);
		return response;
	}
	/**post category
	 * @Param Category**/
	@PostMapping("/category")
	public ResponseEntity<CategoryResponseRest>saveCategory(@RequestBody Category category){
		ResponseEntity<CategoryResponseRest>response= categoryServiceImpl.save(category);
		return response;
	}
	/**Put catggory
	 * @Param id**/
	@PutMapping("/category/{id}")
	public ResponseEntity<CategoryResponseRest>updateCategory(@RequestBody Category category,@PathVariable("id")Long id ){
		ResponseEntity<CategoryResponseRest> response = categoryServiceImpl.update(category, id);
		return response;
	}
	/**Delete category
	 * @Path id**/
	@DeleteMapping("/category/{id}")
	public ResponseEntity<CategoryResponseRest>deleteById(@PathVariable("id")Long id){
		ResponseEntity<CategoryResponseRest>response = categoryServiceImpl.delete(id);
		return response;
	}
}
