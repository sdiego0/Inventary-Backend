package com.conpany.inventary.services;

import org.springframework.http.ResponseEntity;
import com.conpany.inventary.response.CategoryResponseRest;

public interface ICategoryService {

	public ResponseEntity<CategoryResponseRest>search();
}
