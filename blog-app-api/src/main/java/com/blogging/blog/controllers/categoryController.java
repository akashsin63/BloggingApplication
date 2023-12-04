package com.blogging.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.blog.payloads.ApiResponse;
import com.blogging.blog.payloads.CategoryDTO;
import com.blogging.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categoies")
public class categoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDto){
		CategoryDTO createCateogry  = this.categoryService.createCategory(categoryDto);	
		return new ResponseEntity<CategoryDTO>(createCateogry,HttpStatus.CREATED);
	}
	
	//update 
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDto ,
			@PathVariable Integer catId){
		CategoryDTO updatedCateogry	= this.categoryService.updateCategory(categoryDto, catId);
		return new ResponseEntity<CategoryDTO>(updatedCateogry,HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(
			@PathVariable Integer catId){
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted !", false),HttpStatus.OK);
		
	}
	
	//get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer catId){
	CategoryDTO categoryDto = 	this.categoryService.getCategory(catId);
	return new ResponseEntity<CategoryDTO>(categoryDto,HttpStatus.OK);
		
		
	}
	
	//getAll
	@GetMapping("/")
	public ResponseEntity<List> getCategories(){
	    List<CategoryDTO> categories =  this.categoryService.getAllCategory();
	    return ResponseEntity.ok(categories);
	}
}
