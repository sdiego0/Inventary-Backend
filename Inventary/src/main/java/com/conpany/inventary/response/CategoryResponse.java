package com.conpany.inventary.response;

import java.util.List;

import com.conpany.inventary.model.Category;

import lombok.Data;

@Data
public class CategoryResponse {

	private List<Category> category;
}
