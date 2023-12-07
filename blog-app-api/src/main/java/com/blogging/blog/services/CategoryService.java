package com.blogging.blog.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.blogging.blog.payloads.CategoryDTO;

public interface CategoryService {
	
	/// create
	CategoryDTO createCategory(CategoryDTO categoryDto);

	// update
	CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId);

	// delete
	void deleteCategory(Integer categoryId);

	// get
	CategoryDTO getCategory(Integer categoryId);

	// get All

	List<CategoryDTO> getCategories();

}
