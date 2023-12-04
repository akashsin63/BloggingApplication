package com.blogging.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.blog.entites.Categories;
import com.blogging.blog.execptions.ResourceNotFoundException;
import com.blogging.blog.payloads.CategoryDTO;
import com.blogging.blog.reposetories.*;
import com.blogging.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) {
		Categories cat = this.modelMapper.map(categoryDto,Categories.class);
		Categories addedCat =this.categoryRepo.save(cat);
		
		
		return this.modelMapper.map(addedCat,CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId) {
		Categories cat  = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category Id", categoryId));
		cat.setCategoryTitle(categoryDto.getTitle());
		cat.setCategoryDescription(categoryDto.getDiscription());
		Categories updatedCat =  this.categoryRepo.save(cat);
		
		
		return this.modelMapper.map(updatedCat, CategoryDTO.class);
	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Categories cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("category","category Id",categoryId));
		return this.modelMapper.map(cat , CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Categories> cate = this.categoryRepo.findAll();
		List<CategoryDTO> catDto = cate.stream().map((cat)->this.modelMapper.map(cat, CategoryDTO.class)).collect(Collectors.toList());
		return catDto;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Categories cat  = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category Id", categoryId));
		this.categoryRepo.delete(cat);
	}
	
	

}
