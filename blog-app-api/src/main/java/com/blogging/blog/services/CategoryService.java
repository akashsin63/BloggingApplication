package com.blogging.blog.services;

import java.util.List;

import com.blogging.blog.payloads.CategoryDTO;

public interface CategoryService {
	
	//Post
	CategoryDTO createCategory(CategoryDTO categoryDto );
	
	//update
	
	CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId);
	
	//get 
	CategoryDTO getCategory(Integer categoryId);

	
	//getAll
	List<CategoryDTO> getAllCategory();
	
	//delete 
	public void deleteCategory(Integer categoryId);
}
