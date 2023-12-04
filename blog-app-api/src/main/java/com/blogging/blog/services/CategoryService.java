package com.blogging.blog.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.blogging.blog.payloads.CategoryDTO;

public interface CategoryService {
	
	//Post
	CategoryDTO createCategory(CategoryDTO categoryDto );
	
	//update
	
	CategoryDTO updateCategory(CategoryDTO categoryDto, Integer catId);
	
	//get 
	CategoryDTO getCategory(Integer categoryId);

	
	//getAll
	List<CategoryDTO> getAllCategory();
	
	//delete 
	public void deleteCategory(Integer categoryId);
}
